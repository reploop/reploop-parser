package org.reploop.parser.cpp.tree;

import org.reploop.parser.cpp.Node;

import java.util.List;

public class AttributeSpecifiers extends Node {
  List<AttributeSpecifier> specifiers;

  public AttributeSpecifiers(List<AttributeSpecifier> specifiers) {
    this.specifiers = specifiers;
  }

  public List<AttributeSpecifier> getSpecifiers() {
    return specifiers;
  }

  public void setSpecifiers(List<AttributeSpecifier> specifiers) {
    this.specifiers = specifiers;
  }
}
