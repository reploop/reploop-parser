package org.reploop.translator.json.driver;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.type.StructType;
import org.reploop.translator.json.bean.MessageContext;
import org.reploop.translator.json.bean.TypeSimplifier;

import java.util.Optional;

import static org.reploop.translator.json.support.NameSupport.shouldExplicitImport;

public class GoTypeSimplifier extends TypeSimplifier {

	@Override
	protected boolean supportExtends() {
		return false;
	}

	@Override
	public StructType visitStructType(StructType node, MessageContext context) {
		QualifiedName fqn = node.getName();
		if (shouldExplicitImport(fqn, context.getName())) {
			addDependency(fqn, context);
			Optional<QualifiedName> pkg = fqn.prefix().map(p -> QualifiedName.of(p.suffix()));
			return new StructType(QualifiedName.of(pkg, fqn.suffix()));
		}
		return new StructType(fqn.suffix());
	}

	@Override
	protected void addDependency(QualifiedName fqn, MessageContext context) {
		fqn.prefix().ifPresent(context::addDependency);
	}

}
