package org.reploop.parser.thrift.generator;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;
import org.reploop.parser.Classpath;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.commons.LevenshteinDistance;
import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.Node;
import org.reploop.parser.thrift.tree.*;
import org.reploop.parser.thrift.type.BinaryType;
import org.reploop.parser.thrift.type.FieldType;
import org.reploop.parser.thrift.type.StructType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static com.google.common.collect.Iterables.getFirst;

/**
 * Thrift communicates with protobuf by {@link java.nio.ByteBuffer} and vice-verse. Here
 * we try to resolve the original protobuf message type which generates the binary data.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-09 21
 */
public class ThriftBinaryNameResolver extends AstVisitor<Node, Classpath<ThriftProgram>> {

	private static final Logger LOG = LoggerFactory.getLogger(ThriftBinaryNameResolver.class);

	private final Map<String, Set<String>> relations;

	public ThriftBinaryNameResolver(Map<String, Set<String>> relations) {
		this.relations = relations;
	}

	@Override
	public Node visitNode(Node node, Classpath<ThriftProgram> context) {
		return node;
	}

	@Override
	public Entity visitEntity(Entity node, Classpath<ThriftProgram> context) {
		return (Entity) process(node, context);
	}

	@Override
	public Service visitService(Service node, Classpath<ThriftProgram> context) {
		List<Function> functions = node.getFunctions();
		ImmutableList.Builder<Function> fb = ImmutableList.builder();
		if (null != functions) {
			functions.forEach(function -> fb.add(visitFunction(function, context)));
		}
		return new Service(node.getParent(), node.getName(), node.getComments(), fb.build());
	}

	@Override
	public Header visitHeader(Header node, Classpath<ThriftProgram> context) {
		return (Header) process(node, context);
	}

	private Path common;

	private void addInclude(Classpath<ThriftProgram> context) {
		Path path = context.current();
		Path dir = path.getParent();
		if (null == common) {
			common = dir.resolve("common.thrift");
		}
		for (Map.Entry<String, Set<String>> entry : relations.entrySet()) {
			String filename = entry.getKey();
			if (path.endsWith(filename)) {
				Set<String> names = entry.getValue();
				if (null != names) {
					for (String name : names) {
						Path p = dir.resolve(name);
						if (Files.exists(p)) {
							context.file(p);
						}
					}
				}
			}
		}
		if (null != common) {
			context.file(common);
		}
	}

	private static final QualifiedName prefix = QualifiedName.of("qipu");

	@Override
	public Namespace visitNamespace(Namespace node, Classpath<ThriftProgram> context) {
		NamespaceScope scope = node.getScope();
		if (scope.support(Lang.JAVA)) {
			return new Namespace(scope, QualifiedName.of(prefix, node.getNamespace()).toString());
		}
		return node;
	}

	@Override
	public ThriftProgram visitProgram(ThriftProgram node, Classpath<ThriftProgram> context) {
		addInclude(context);
		List<Header> headers = node.getHeaders();
		ImmutableList.Builder<Header> hb = ImmutableList.builder();
		if (null != headers) {
			headers.forEach(header -> hb.add(visitHeader(header, context)));
		}

		List<Entity> entities = node.getEntities();
		ImmutableList.Builder<Entity> eb = ImmutableList.builder();
		if (null != entities) {
			entities.forEach(entity -> eb.add(visitEntity(entity, context)));
		}

		ThriftProgram program = new ThriftProgram(node.getComments(), hb.build(), eb.build());
		program.setFile(node.getFile());
		return program;
	}

	@Override
	public Field visitField(Field field, Classpath<ThriftProgram> context) {
		return visitField(null, field, context);
	}

	private QualifiedName convert(String suffix, CaseFormat format) {
		String name = name(suffix, format);
		return QualifiedName.of(type(name, CaseFormat.LOWER_CAMEL));
	}

	private Optional<String> rename(String name) {
		if (name.endsWith("Request")) {
			return Optional.empty();
		}
		else {
			return Optional.of(name + "Request");
		}
	}

	private Field visitField(Function function, Field field, Classpath<ThriftProgram> context) {
		// We only need rewrite the field in the function.
		if (null != context) {
			Set<QualifiedName> names = new HashSet<>();
			String name = name(field.getName().suffix());
			QualifiedName qualified = convert(name, CaseFormat.LOWER_CAMEL);
			// #1 The parameter name
			names.add(qualified);
			if (null != function) {
				// #2 The parameter name end with Request if not.
				rename(name).ifPresent(n -> names.add(convert(n, CaseFormat.LOWER_CAMEL)));
				// #3 The function name end with Request
				rename(function.getName().suffix()).ifPresent(n -> names.add(convert(n, CaseFormat.LOWER_CAMEL)));
			}
			Map<QualifiedName, TreeMap<Integer, List<QualifiedName>>> localDistanceMap = new HashMap<>();
			QualifiedName found = null;
			for (QualifiedName qn : names) {
				Optional<QualifiedName> f = resolve(qn, context);
				if (f.isPresent()) {
					found = f.get();
					break;
				}
			}
			if (null == found) {
				for (QualifiedName qn : names) {
					Optional<QualifiedName> f = closestMatch(qn);
					if (f.isPresent()) {
						found = f.get();
						break;
					}
				}
			}
			if (null == found) {
				found = qualified;
			}
			StructType type = new StructType(found);
			return new Field(field.getComments(), type, field.getFiledId(), name, field.isRequired());
		}
		else {
			return field;
		}
	}

	@Override
	public FieldType visitFieldType(FieldType fieldType, Classpath<ThriftProgram> context) {
		return (FieldType) process(fieldType, context);
	}

	@Override
	public ReturnType visitReturnType(ReturnType node, Classpath<ThriftProgram> context) {
		return new ReturnType(visitFieldType(node.getFieldType(), context));
	}

	@Override
	public FunctionType visitFunctionType(FunctionType node, Classpath<ThriftProgram> context) {
		return (FunctionType) process(node, context);
	}

	private String name(String name) {
		return name(name, CaseFormat.LOWER_UNDERSCORE);
	}

	private String name(String name, CaseFormat format) {
		return format.to(CaseFormat.LOWER_CAMEL, name);
	}

	private String type(QualifiedName name, CaseFormat format) {
		return type(name.suffix(), format);
	}

	private String type(String name) {
		return type(name, CaseFormat.LOWER_UNDERSCORE);
	}

	private String type(String name, CaseFormat format) {
		return format.to(CaseFormat.UPPER_CAMEL, name);
	}

	private List<String> names(String name) {
		char[] chars = name.toCharArray();
		List<String> names = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (char ch : chars) {
			if (sb.length() > 0 && Character.isAlphabetic(ch) && Character.isUpperCase(ch)) {
				names.add(sb.toString());
				sb.setLength(0);
			}
			sb.append(ch);
		}
		names.add(sb.toString());
		Collections.sort(names);
		return names;
	}

	@Override
	public Function visitFunction(Function node, Classpath<ThriftProgram> context) {
		// Add thrift exception
		ImmutableList.Builder<Field> fb = ImmutableList.builder();
		node.getExceptions().ifPresent(fb::addAll);
		fb.add(new Field(Collections.emptyList(), new StructType("TException"), 0, "e", true));
		fb.add(new Field(Collections.emptyList(), new StructType("InvalidProtocolBufferException"), 0, "e", true));

		// Rewrite parameters
		List<Field> params = node.getParameters();
		final ImmutableList.Builder<Field> pb = ImmutableList.builder();
		if (null != params) {
			params.forEach(field -> pb.add(visitField(node, field, context)));
		}

		List<Field> parameters = pb.build();

		boolean should = false;
		FunctionType functionType = node.getReturnType();
		if (functionType instanceof ReturnType) {
			ReturnType returnType = (ReturnType) functionType;
			FieldType fieldType = returnType.getFieldType();
			if (fieldType instanceof BinaryType) {
				should = true;
			}
		}
		if (should) {
			List<Field> fields = guessReturnType(node, context, parameters);
			functionType = resolveFunctionType(node, context, fields);
		}
		return new Function(node.getComments(), node.isOneWay(), node.getName(), functionType, parameters,
				Optional.of(fb.build()));
	}

	private Map<QualifiedName, TreeMap<Integer, List<QualifiedName>>> distanceMap = new HashMap<>();

	public void set(QualifiedName name, QualifiedName qn, int distance) {
		distanceMap.computeIfAbsent(name, n -> new TreeMap<>())
			.computeIfAbsent(distance, d -> new ArrayList<>())
			.add(qn);
	}

	private Optional<QualifiedName> closestMatch(QualifiedName name) {
		Map.Entry<Integer, List<QualifiedName>> entry = distanceMap.computeIfAbsent(name, qn -> new TreeMap<>())
			.firstEntry();
		if (null != entry) {
			Integer distance = entry.getKey();
			List<QualifiedName> names = entry.getValue();
			if (null != names && 1 == names.size()) {
				QualifiedName candidate = names.get(0);
				LOG.warn("name: {}, candidate: {}, distance: {}", name, candidate, distance);
				return Optional.ofNullable(candidate);
			}
		}
		return Optional.empty();
	}

	private boolean hasExactMatch(QualifiedName name) {
		Integer value = distanceMap.computeIfAbsent(name, qn -> new TreeMap<>()).floorKey(0);
		return null != value;
	}

	private Optional<QualifiedName> resolve(QualifiedName name, Set<QualifiedName> names) {
		for (QualifiedName qn : names) {
			if (null == qn) {
				continue;
			}
			if (qn.endsWith(name)) {
				return Optional.of(qn);
			}
			else {
				int distance = LevenshteinDistance.compute(name.suffix(), qn.suffix());
				set(name, qn, distance);
			}
		}
		return Optional.empty();
	}

	private Optional<QualifiedName> resolve(QualifiedName name, Classpath<ThriftProgram> context) {
		distanceMap.clear();
		Optional<QualifiedName> qn = resolve(name, context, context.current(), new HashSet<>());
		if (qn.isPresent()) {
			return qn;
		}
		else {
			return Optional.empty();
		}
	}

	private Optional<QualifiedName> resolve(QualifiedName name, Classpath<ThriftProgram> context, Path file,
			Set<Path> searched) {
		// #1 Search the current file.
		if (null != file && !searched.contains(file)) {
			Set<QualifiedName> names = context.names(file);
			Optional<QualifiedName> qn = resolve(name, names);
			searched.add(file);
			if (qn.isPresent()) {
				return qn;
			}
		}
		// #2 Search the imported files.
		Set<Path> imports = context.files(file);
		if (null != imports) {
			for (Path path : imports) {
				if (null == path || searched.contains(path)) {
					continue;
				}
				Optional<QualifiedName> resolved = resolve(name, context, path, searched);
				if (resolved.isPresent()) {
					return resolved;
				}
			}
		}
		return Optional.empty();
	}

	private FunctionType resolveFunctionType(Function node, Classpath<ThriftProgram> context, List<Field> sources) {
		Optional<QualifiedName> found = Optional.empty();
		for (Field source : sources) {
			FieldType fieldType = source.getFieldType();
			QualifiedName name = fieldType.getName();
			found = resolve(name, context);
			if (found.isPresent()) {
				set(name, found.get(), 0);
				break;
			}
		}
		FunctionType returnType;
		if (found.isPresent()) {
			returnType = new ReturnType(new StructType(found.get()));
		}
		else {
			returnType = node.getReturnType();
		}
		return returnType;
	}

	private List<Field> guessReturnType(Function node, Classpath<ThriftProgram> context, List<Field> parameters) {
		// #1 We may need to guess return type from the function name.
		String type = type(node.getName() + "Response", CaseFormat.LOWER_CAMEL);
		Field nameField = new Field(Collections.emptyList(), new StructType(type), 0, node.getName(), false);

		// #2 Guess from the first parameter, then rewrite return type
		Field field = getFirst(parameters, nameField);

		List<Field> fields = new ArrayList<>();
		if (null != field) {
			QualifiedName name = field.getFieldType().getName().replace("Request", "Response");
			fields.add(new Field(field.getComments(), new StructType(name), field.getFiledId(), field.getName(),
					field.isRequired()));
		}
		// In case we have an empty parameter list, use the function name one.
		if (field != nameField) {
			fields.add(nameField);
		}

		Path current = context.current();
		Path cn = current.getFileName();
		if (cn.endsWith("write_rpc_service.thrift")) {
			fields.add(new Field(Collections.emptyList(), new StructType("WriteResponse"), 0, "writeResponse", false));
		}
		else if (cn.endsWith("id_rpc_service.thrift")) {
			fields.add(new Field(Collections.emptyList(), new StructType("IdServiceResponse"), 0, "idServiceResponse",
					false));
		}
		else if (cn.endsWith("query_rpc_service.thrift")) {
			fields.add(new Field(Collections.emptyList(), new StructType("QueryResponse"), 0, "queryResponse", false));
		}
		fields.sort((o1, o2) -> {
			FieldType ft1 = o1.getFieldType();
			FieldType ft2 = o2.getFieldType();
			return ft1.getName().size() - ft2.getName().size();
		});
		Field previous = null;
		Iterator<Field> it = fields.iterator();
		while (it.hasNext()) {
			Field now = it.next();
			if (null != previous) {
				FieldType ft1 = previous.getFieldType();
				FieldType ft2 = now.getFieldType();
				if (ft1.getName().equals(ft2.getName())) {
					it.remove();
				}
			}
			previous = now;
		}
		return fields;
	}

}
