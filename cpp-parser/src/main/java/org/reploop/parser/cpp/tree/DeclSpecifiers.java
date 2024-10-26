package org.reploop.parser.cpp.tree;

import org.reploop.parser.cpp.Node;

import java.util.List;

public class DeclSpecifiers extends Node {

	List<DeclSpecifier> specifiers;

	public DeclSpecifiers(List<DeclSpecifier> specifiers) {
		this.specifiers = specifiers;
	}

	public List<DeclSpecifier> getSpecifiers() {
		return specifiers;
	}

	public void setSpecifiers(List<DeclSpecifier> specifiers) {
		this.specifiers = specifiers;
	}

}
