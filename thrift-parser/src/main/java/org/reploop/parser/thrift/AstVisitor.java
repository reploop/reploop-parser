package org.reploop.parser.thrift;

import org.reploop.parser.thrift.tree.*;
import org.reploop.parser.thrift.tree.Enum;
import org.reploop.parser.thrift.tree.Exception;
import org.reploop.parser.thrift.type.*;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-07-03 00
 */
public abstract class AstVisitor<R, C> {

	public R visitNode(Node node, C context) {
		return null;
	}

	public R process(Node node, C context) {
		return node.accept(this, context);
	}

	public R visitCollectionType(CollectionType collectionType, C context) {
		return visitNode(collectionType, context);
	}

	public R visitDefinition(Definition node, C context) {
		return visitNode(node, context);
	}

	public R visitEntity(Entity node, C context) {
		return visitNode(node, context);
	}

	public R visitEnum(Enum node, C context) {
		return visitNode(node, context);
	}

	public R visitEnumField(EnumField node, C context) {
		return visitNode(node, context);
	}

	public R visitException(Exception node, C context) {
		return visitNode(node, context);
	}

	public R visitField(Field node, C context) {
		return visitNode(node, context);
	}

	public R visitFunction(Function node, C context) {
		return visitNode(node, context);
	}

	public R visitReturnType(ReturnType node, C context) {
		return visitNode(node, context);
	}

	public R visitFunctionType(FunctionType node, C context) {
		return visitNode(node, context);
	}

	public R visitHeader(Header node, C context) {
		return visitNode(node, context);
	}

	public R visitInclude(Include node, C context) {
		return visitNode(node, context);
	}

	public R visitLiteralNode(LiteralNode node, C context) {
		return visitNode(node, context);
	}

	public R visitNamespace(Namespace node, C context) {
		return visitNode(node, context);
	}

	public R visitNamespaceScope(NamespaceScope node, C context) {
		return visitNode(node, context);
	}

	public R visitRaise(Raise node, C context) {
		return visitNode(node, context);
	}

	public R visitService(Service node, C context) {
		return visitNode(node, context);
	}

	public R visitStruct(Struct node, C context) {
		return visitNode(node, context);
	}

	public R visitProgram(ThriftProgram node, C context) {
		return visitNode(node, context);
	}

	public R visitVoidType(VoidType node, C context) {
		return visitNode(node, context);
	}

	public R visitBoolType(BoolType boolType, C context) {
		return visitNode(boolType, context);
	}

	public R visitBinaryType(BinaryType binaryType, C context) {
		return visitNode(binaryType, context);
	}

	public R visitByteType(ByteType byteType, C context) {
		return visitNode(byteType, context);
	}

	public R visitDoubleType(DoubleType doubleType, C context) {
		return visitNode(doubleType, context);
	}

	public R visitFieldType(FieldType fieldType, C context) {
		return visitNode(fieldType, context);
	}

	public R visitFloatType(FloatType floatType, C context) {
		return visitNode(floatType, context);
	}

	public R visitIntType(IntType intType, C context) {
		return visitNode(intType, context);
	}

	public R visitListType(ListType listType, C context) {
		return visitNode(listType, context);
	}

	public R visitLongType(LongType longType, C context) {
		return visitNode(longType, context);
	}

	public R visitMapType(MapType mapType, C context) {
		return visitNode(mapType, context);
	}

	public R visitSetType(SetType setType, C context) {
		return visitNode(setType, context);
	}

	public R visitShortType(ShortType shortType, C context) {
		return visitNode(shortType, context);
	}

	public R visitStringType(StringType stringType, C context) {
		return visitNode(stringType, context);
	}

	public R visitStructType(StructType structType, C context) {
		return visitNode(structType, context);
	}

}
