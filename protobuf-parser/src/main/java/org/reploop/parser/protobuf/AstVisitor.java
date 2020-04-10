package org.reploop.parser.protobuf;


import org.reploop.parser.ast.AbstractAstVisitor;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;

/**
 * Protobuf AST visitor.
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-07-03 00
 */
public abstract class AstVisitor<R, C> extends AbstractAstVisitor<R, Node, C> {
    public abstract R visitNode(Node node, C context);

    @Override
    public R process(Node node, C context) {
        return node.accept(this, context);
    }

    public R visitCollectionType(CollectionType collectionType, C context) {
        return visitNode(collectionType, context);
    }

    public R visitMessage(Message node, C context) {
        return visitNode(node, context);
    }

    public R visitBoolValue(BoolValue node, C context) {
        return visitNode(node, context);
    }

    public R visitCommonPair(CommonPair node, C context) {
        return visitNode(node, context);
    }

    public R visitDefaultPair(DefaultPair node, C context) {
        return visitNode(node, context);
    }

    public R visitEnumeration(Enumeration node, C context) {
        return visitNode(node, context);
    }

    public R visitEnumField(EnumField node, C context) {
        return visitNode(node, context);
    }

    public R visitField(Field node, C context) {
        return visitNode(node, context);
    }

    public R visitOption(Option option, C context) {
        return visitNode(option, context);
    }

    public R visitHeader(Header node, C context) {
        return visitNode(node, context);
    }

    public R visitInclude(Include node, C context) {
        return visitNode(node, context);
    }

    public R visitIntValue(IntValue node, C context) {
        return visitNode(node, context);
    }

    public R visitNamespace(Namespace node, C context) {
        return visitNode(node, context);
    }

    public R visitOptionPair(OptionPair node, C context) {
        return visitNode(node, context);
    }

    public R visitOptions(Options node, C context) {
        return visitNode(node, context);
    }

    public R visitPair(Pair node, C context) {
        return visitNode(node, context);
    }

    public R visitProtobufProgram(ProtoProgram node, C context) {
        return visitNode(node, context);
    }

    public R visitService(Service node, C context) {
        return visitNode(node, context);
    }

    public R visitStringValue(StringValue node, C context) {
        return visitNode(node, context);
    }

    public R visitStructValue(StructValue node, C context) {
        return visitNode(node, context);
    }

    public R visitValue(Value node, C context) {
        return visitNode(node, context);
    }

    public R visitBoolType(BoolType boolType, C context) {
        return visitNode(boolType, context);
    }

    public R visitByteStringType(ByteStringType byteStringType, C context) {
        return visitNode(byteStringType, context);
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

    public R visitFunction(Function function, C context) {
        return visitNode(function, context);
    }
}
