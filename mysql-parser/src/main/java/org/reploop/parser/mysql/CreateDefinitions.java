package org.reploop.parser.mysql;

import com.google.common.base.MoreObjects;
import com.qiyi.walle.parser.mysql.tree.CreateDefinition;
import com.qiyi.walle.parser.mysql.tree.Node;

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
