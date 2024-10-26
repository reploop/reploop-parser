package org.reploop.parser.cpp.tree;

import org.reploop.parser.cpp.Node;

public class Program extends Node {

	private Declarations declarations;

	public Program(Declarations declarations) {
		this.declarations = declarations;
	}

	public Declarations getDeclarations() {
		return declarations;
	}

	public void setDeclarations(Declarations declarations) {
		this.declarations = declarations;
	}

}
