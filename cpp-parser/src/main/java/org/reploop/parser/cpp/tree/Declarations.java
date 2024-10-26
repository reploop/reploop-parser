package org.reploop.parser.cpp.tree;

import org.reploop.parser.cpp.Node;

import java.util.List;

public class Declarations extends Node {

	private List<Declaration> declarations;

	public Declarations(List<Declaration> declarations) {
		this.declarations = declarations;
	}

	public List<Declaration> getDeclarations() {
		return declarations;
	}

	public void setDeclarations(List<Declaration> declarations) {
		this.declarations = declarations;
	}

}
