package org.reploop.translator.json.support;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageInfer {

	final Map<QualifiedName, Integer> nameIndexMap = new HashMap<>();

	final Map<Integer, QualifiedName> indexNameMap = new HashMap<>();

	final Map<Field, Integer> fieldIndexMap = new HashMap<>();

	final Map<Integer, Field> indexFieldMap = new HashMap<>();

	public Optional<Rect> maxArea(Map<QualifiedName, Message> messageMap) {
		// message and field name to index
		index(messageMap);
		Matrix matrix = init(messageMap);
		matrix.print();
		return matrix.maxArea();
	}

	/**
	 * Try to index the message and it's fields. Matrix's row are fields indexed as zero
	 * based index, and each column a message indexed as zero based index.
	 * @param messageMap the messages.
	 */
	private void index(Map<QualifiedName, Message> messageMap) {
		AtomicInteger mi = new AtomicInteger(0);
		AtomicInteger fi = new AtomicInteger(0);
		for (Map.Entry<QualifiedName, Message> entry : messageMap.entrySet()) {
			QualifiedName key = entry.getKey();
			nameIndexMap.computeIfAbsent(key, name -> mi.getAndIncrement());
			indexNameMap.put(nameIndexMap.get(key), key);
			Message message = entry.getValue();
			List<Field> fields = message.getFields();
			for (Field field : fields) {
				fieldIndexMap.computeIfAbsent(field, value -> fi.getAndIncrement());
				indexFieldMap.put(fieldIndexMap.get(field), field);
			}
		}
	}

	/**
	 * Analyze fields.
	 * @param messageMap messages
	 * @return parent info
	 */
	public Optional<Parent> analyze(Map<QualifiedName, Message> messageMap) {
		// message and field name to index
		index(messageMap);
		Matrix matrix = init(messageMap);
		matrix.print();
		// calculate max rect
		Optional<Rect> or = matrix.maxArea();
		if (or.isPresent()) {
			Rect rect = or.get();
			// Fields may be in parent class
			Set<Field> fields = new HashSet<>();
			for (int f = rect.lt.x; f <= rect.rb.x; f++) {
				Field field = indexFieldMap.get(f);
				fields.add(field);
			}
			// Messages may have common parent class
			List<Message> messages = new ArrayList<>();
			for (int m = rect.lt.y; m <= rect.rb.y; m++) {
				QualifiedName qn = indexNameMap.get(m);
				Message message = messageMap.get(qn);
				messages.add(message);
			}
			return Optional.of(new Parent(messages, fields));
		}
		return Optional.empty();
	}

	private Matrix init(Map<QualifiedName, Message> messageMap) {
		int rows = fieldIndexMap.size() + 1;
		int columns = nameIndexMap.size() + 1;
		Matrix matrix = Matrix.create(rows, columns);
		// create row and column mapping
		// Each row is a field
		// Each column is a message.
		for (Map.Entry<QualifiedName, Message> entry : messageMap.entrySet()) {
			QualifiedName key = entry.getKey();
			int j = nameIndexMap.get(key);
			Message message = entry.getValue();
			List<Field> fields = message.getFields();
			for (Field field : fields) {
				int i = fieldIndexMap.get(field);
				// if a field in a message, set 1.
				matrix.set(i, j);
			}
		}
		// compute score
		matrix.computeScore();
		sort(matrix);
		return matrix;
	}

	/**
	 * Sort the matrix and swap fields and messages if needed to maintain index to field
	 * or message mapping.
	 * @param matrix the matrix.
	 */
	private void sort(Matrix matrix) {
		matrix.sort((j, jn) -> {
			Field fj = indexFieldMap.remove(j);
			Field fjn = indexFieldMap.remove(jn);
			fieldIndexMap.put(fj, jn);
			indexFieldMap.put(jn, fj);
			fieldIndexMap.put(fjn, j);
			indexFieldMap.put(j, fjn);
		}, (j, jn) -> {
			QualifiedName qj = indexNameMap.remove(j);
			QualifiedName qjn = indexNameMap.remove(jn);
			nameIndexMap.put(qj, jn);
			indexNameMap.put(jn, qj);
			nameIndexMap.put(qjn, j);
			indexNameMap.put(j, qjn);
		});
	}

}
