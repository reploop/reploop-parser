package org.reploop.parser.protobuf.tree;

import org.reploop.parser.protobuf.AstVisitor;

import java.util.Objects;

/**
 * The protocol compiler searches for imported files in a set of directories specified on the
 * protocol compiler command line using the -I/--proto_path flag. If no flag was given, it looks in
 * the directory in which the compiler was invoked. In general, you should set the --proto_path flag
 * to the root of your project and use fully qualified names for all imports.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 11
 */
public class Include extends Header {
    String file;


    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitInclude(this, context);
    }

    public Include(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Include include = (Include) o;
        return Objects.equals(file, include.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file);
    }

    @Override
    public String toString() {
        return "Include{" +
                "file='" + file + '\'' +
                '}';
    }
}
