package org.reploop.translator.json.support;

import org.reploop.parser.QualifiedName;

import java.util.Set;

public class NameSupport {
    public static final QualifiedName JAVA_LANG = QualifiedName.of("java.lang");
    public static final QualifiedName JAVA_OBJECT = QualifiedName.of("Object");
    public static final QualifiedName JAVA_LANG_OBJECT = QualifiedName.of(JAVA_LANG, JAVA_OBJECT);
    public static final QualifiedName IMPORT_JSON_PROPERTY = QualifiedName.of("com.fasterxml.jackson.annotation.JsonProperty");
    public static final QualifiedName IMPORT_JSON_FORMAT = QualifiedName.of("com.fasterxml.jackson.annotation.JsonFormat");
    public static final QualifiedName IMPORT_JSON_IGNORE = QualifiedName.of("com.fasterxml.jackson.annotation.JsonIgnoreProperties");
    public static final QualifiedName IMPORT_SERIALIZABLE = QualifiedName.of("java.io.Serializable");
    public static final QualifiedName IMPORT_MORE_OBJECTS = QualifiedName.of("com.google.common.base.MoreObjects");
    public static final QualifiedName IMPORT_LIST = QualifiedName.of("java.util.List");
    public static final QualifiedName IMPORT_LOCAL_DATETIME = QualifiedName.of("java.time.LocalDateTime");
    public static final QualifiedName IMPORT_SET = QualifiedName.of("java.util.Set");
    public static final QualifiedName IMPORT_MAP = QualifiedName.of("java.util.Map");

    public static boolean isObject(QualifiedName qn) {
        return JAVA_OBJECT.equals(qn) || JAVA_LANG_OBJECT.equals(qn);
    }

    public static boolean autoImported(QualifiedName qn) {
        // java.lang.* are auto imported by default
        return isObject(qn) || qn.prefix().filter(name -> name.equals(JAVA_LANG)).isPresent();
    }

    /**
     * Test if {@link  QualifiedName qn} should explicit import against {@code exist}
     *
     * @param qn    the dependency qualified name.
     * @param exist the current message
     * @return true for explicitly import
     */
    public static boolean shouldExplicitImport(QualifiedName qn, QualifiedName exist) {
        // #0 First, java.lang.object can ignore safely
        if (autoImported(qn)) {
            return false;
        }
        // #1 Then make sure they are not same
        if (qn.equals(exist)) {
            return false;
        }
        // #2 Test if same package but different class name
        int c = Integer.compare(qn.size(), exist.size());
        // #3 They are of same size.
        if (0 == c) {
            int s = qn.size() - 1;
            for (int i = 0; i < s; i++) {
                String p1 = qn.partAt(i);
                String p2 = exist.partAt(i);
                if (!p1.equals(p2)) {
                    // #4 They are in different packages, so need import explicitly.
                    return true;
                }
            }
            // #5 Now we can tell the two in the same package, so do not need to import explicitly.
            return false;
        }
        return true;
    }

    /**
     * Test if the two names are conflicts
     *
     * @param qn    the name that is going to test
     * @param exist the current name tested against
     * @return true or false
     */
    public static boolean hasNameConflict(QualifiedName qn, QualifiedName exist) {
        if (null == qn || null == exist) {
            return false;
        }
        return !qn.equals(exist) && qn.endsWith(exist.suffix());
    }

    /**
     * Test if qn conflicts  with any of the deps.
     *
     * @param qn   name
     * @param deps deps
     * @return true or false
     */
    public static boolean hasNameConflict(QualifiedName qn, Set<QualifiedName> deps) {
        boolean conflict = false;
        // Current deps
        for (QualifiedName name : deps) {
            if (hasNameConflict(qn, name)) {
                conflict = true;
                break;
            }
        }
        return conflict;
    }
}
