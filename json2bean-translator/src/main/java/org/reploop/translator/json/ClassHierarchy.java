package org.reploop.translator.json;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ClassHierarchy {

    private List<Field> fields;

    private void index(Map<QualifiedName, Message> messageMap,
                       Map<QualifiedName, Integer> nameIndexMap, Map<Integer, QualifiedName> indexNameMap,
                       Map<Field, Integer> fieldIndexMap, Map<Integer, Field> indexFieldMap) {
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

    private int[][] init(int messageCount, int fieldCount) {
        int fc = fieldCount + 1;
        int mc = messageCount + 1;
        int[][] matrix = new int[fc][mc];
        for (int f = 0; f < fc; f++) {
            for (int m = 0; m < mc; m++) {
                matrix[f][m] = 0;
            }
        }
        return matrix;
    }

    public void infer(Map<QualifiedName, Message> messageMap) {
        Map<QualifiedName, Integer> nameIndexMap = new HashMap<>();
        Map<Integer, QualifiedName> indexNameMap = new HashMap<>();
        Map<Field, Integer> fieldIndexMap = new HashMap<>();
        Map<Integer, Field> indexFieldMap = new HashMap<>();
        // message and field name to index
        index(messageMap, nameIndexMap, indexNameMap, fieldIndexMap, indexFieldMap);

        // data matrix size
        int ms = nameIndexMap.size();
        int fs = fieldIndexMap.size();

        // actual matrix size
        int mc = ms + 1;
        int fc = fs + 1;

        // init matrix
        int[][] matrix = init(messageMap, nameIndexMap, fieldIndexMap);
        // sum rows and columns
        for (int i = 0; i < fs; i++) {
            for (int j = 0; j < ms; j++) {
                matrix[i][ms] += matrix[i][j];
                matrix[fs][j] += matrix[i][j];
            }
        }
        // sort matrix
        sort(nameIndexMap, indexNameMap, fieldIndexMap, indexFieldMap, ms, fs, mc, fc, matrix);
        // print out
        print(ms, fs, matrix);
        // generate parent message
        infer(messageMap, indexNameMap, indexFieldMap, ms, fs, matrix);

    }

    private void infer(Map<QualifiedName, Message> messageMap,
                       Map<Integer, QualifiedName> indexNameMap, Map<Integer, Field> indexFieldMap,
                       int ms, int fs, int[][] matrix) {
        Map<QualifiedName, List<QualifiedName>> same = new HashMap<>();
        // calculate max rect
        Optional<Rect> or = maxArea(matrix, fs, ms);
        if (or.isPresent()) {
            Rect rect = or.get();

            // Fields in parent class
            Set<Field> fields = new HashSet<>();
            for (int f = rect.lt.x; f <= rect.rb.x; f++) {
                Field field = indexFieldMap.get(f);
                fields.add(field);
            }

            Message parent = null;
            QualifiedName name = null;

            List<Message> subClasses = new ArrayList<>();
            StringBuilder n = new StringBuilder();
            // Message will extend the parent
            for (int m = rect.lt.y; m <= rect.rb.y; m++) {
                QualifiedName qn = indexNameMap.get(m);
                if (n.length() == 0) {
                    n.append(qn.toString());
                }
                n.append(m);

                Message message = messageMap.get(qn);
                List<Field> sub = message.getFields().stream()
                    .filter(field -> !fields.contains(field))
                    .collect(Collectors.toList());
                // Same as parent
                if (sub.isEmpty()) {
                    if (null == parent) {
                        parent = message;
                    } else {
                        // They are same, replace them with parent class.
                        same.computeIfAbsent(qn, qualifiedName -> new ArrayList<>()).add(parent.getName());
                    }
                } else {
                    Message subMessage = new Message(qn, sub, message.getMessages(), message.getEnumerations(), message.getOptions());
                    subClasses.add(subMessage);
                    // Update class.
                    messageMap.put(qn, subMessage);
                }
            }
            if (null == parent) {
                name = QualifiedName.of(n.toString());
                parent = new Message(name, new ArrayList<>(fields));
            } else {
                name = parent.getName();
            }
            List<Message> messages = parent.getMessages();
            if (null != messages) {
                subClasses.addAll(messages);
            }
            Message pm = new Message(name, parent.getFields(), subClasses, parent.getEnumerations(), parent.getOptions());
            messageMap.put(name, pm);
        }
    }

    private void print(int ms, int fs, int[][] matrix) {
        System.out.printf("%3d", 0);
        for (int j = 0; j <= ms; j++) {
            System.out.printf("%3d", j);
        }
        System.out.println();
        for (int i = 0; i < fs + 1; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < ms + 1; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private void sort(Map<QualifiedName, Integer> nameIndexMap, Map<Integer, QualifiedName> indexNameMap,
                      Map<Field, Integer> fieldIndexMap, Map<Integer, Field> indexFieldMap,
                      int ms, int fs, int mc, int fc, int[][] matrix) {
        // rows
        for (int i = 0; i < fs; i++) {
            for (int j = 0; j < fs - i - 1; j++) {
                int vc = matrix[j][ms];
                int jn = j + 1;
                int vn = matrix[jn][ms];
                if (vc < vn) {
                    // swap row j and j+1
                    swapRow(matrix, j, jn, mc);
                    Field fj = indexFieldMap.remove(j);
                    Field fjn = indexFieldMap.remove(jn);
                    fieldIndexMap.put(fj, jn);
                    indexFieldMap.put(jn, fj);
                    fieldIndexMap.put(fjn, j);
                    indexFieldMap.put(j, fjn);
                }
            }
        }

        // columns
        for (int i = 0; i < ms; i++) {
            for (int j = 0; j < ms - i - 1; j++) {
                int vc = matrix[fs][j];
                int jn = j + 1;
                int vn = matrix[fs][jn];
                if (vc < vn) {
                    // swap column j and j+1
                    swapColumn(matrix, j, jn, fc);
                    QualifiedName qj = indexNameMap.remove(j);
                    QualifiedName qjn = indexNameMap.remove(jn);
                    nameIndexMap.put(qj, jn);
                    indexNameMap.put(jn, qj);
                    nameIndexMap.put(qjn, j);
                    indexNameMap.put(j, qjn);
                }
            }
        }
    }

    private boolean isSet(int[][] matrix, int f, int m) {
        return matrix[f][m] == 1;
    }

    private boolean maxRect(int[][] matrix, int f1, int m1, int f2, int m2) {
        int f = f1;
        for (; f <= f2; f++) {
            int m = m1;
            for (; m <= m2; m++) {
                if (!isSet(matrix, f, m)) {
                    break;
                }
            }
            if (m <= m2) {
                break;
            }
        }
        return f > f2;
    }

    public Point maxArea(int[][] matrix, int fs, int ms, int f, int m) {
        int maxArea = 0;
        int mf = 0;
        int mm = 0;
        for (int f1 = f; f1 < fs; f1++) {
            for (int m1 = m; m1 < ms; m1++) {
                if (maxRect(matrix, f, m, f1, m1)) {
                    int area = (f1 - f + 1) * (m1 - m + 1);
                    if (area > maxArea) {
                        maxArea = area;
                        mf = f1;
                        mm = m1;
                    }
                }
            }
        }
        return new Point(mf, mm);
    }

    public Optional<Rect> maxArea(int[][] matrix, int fs, int ms) {
        int maxArea = 0;
        Point lt = new Point();
        Point rb = new Point();
        for (int f = 0; f < fs; f++) {
            for (int m = 0; m < ms; m++) {
                Point p = maxArea(matrix, fs, ms, f, m);
                if (p.x > 0 && p.y > 0) {
                    int area = (p.x - f + 1) * (p.y - m + 1);
                    if (area > maxArea) {
                        maxArea = area;
                        lt.x = f;
                        lt.y = m;
                        rb.x = p.x;
                        rb.y = p.y;
                    }
                    // System.out.printf("(%d,%d)-(%d,%d)=%d%n", f, m, p.x, p.y, area);
                }
            }
        }
        System.out.printf("(%d,%d)-(%d,%d)=%d%n", lt.x, lt.y, rb.x, rb.y, maxArea);
        if (maxArea > 0) {
            return Optional.of(new Rect(lt, rb));
        }
        return Optional.empty();
    }

    private int[][] init(Map<QualifiedName, Message> messageMap,
                         Map<QualifiedName, Integer> nameIndexMap,
                         Map<Field, Integer> fieldIndexMap) {
        int[][] matrix = init(nameIndexMap.size(), fieldIndexMap.size());
        for (Map.Entry<QualifiedName, Message> entry : messageMap.entrySet()) {
            QualifiedName key = entry.getKey();
            int j = nameIndexMap.get(key);
            Message message = entry.getValue();
            List<Field> fields = message.getFields();
            for (Field field : fields) {
                int i = fieldIndexMap.get(field);
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    private void swapRow(int[][] matrix, int r1, int r2, int length) {
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = matrix[r1][i];
            matrix[r1][i] = matrix[r2][i];
            matrix[r2][i] = temp[i];
        }
    }

    private void swapColumn(int[][] matrix, int c1, int c2, int length) {
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = matrix[i][c1];
            matrix[i][c1] = matrix[i][c2];
            matrix[i][c2] = temp[i];
        }
    }
}
