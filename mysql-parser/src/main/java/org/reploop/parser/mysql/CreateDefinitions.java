package org.reploop.parser.mysql;

import com.google.common.base.MoreObjects;
import org.reploop.parser.mysql.tree.CreateDefinition;
import org.reploop.parser.mysql.tree.Node;

import java.util.List;

public class CreateDefinitions extends Node {
    List<CreateDefinition> definitions;

    public List<CreateDefinition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<CreateDefinition> definitions) {
        this.definitions = definitions;
    }

    public CreateDefinitions(List<CreateDefinition> definitions) {
        this.definitions = definitions;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("definitions", definitions)
                .toString();
    }
}
