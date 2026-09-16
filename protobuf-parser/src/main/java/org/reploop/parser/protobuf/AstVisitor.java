package org.reploop.parser.protobuf;

import org.reploop.parser.ast.AbstractAstVisitor;
import org.reploop.parser.protobuf.tree.BoolValue;
import org.reploop.parser.protobuf.tree.CommonPair;
import org.reploop.parser.protobuf.tree.DefaultPair;
import org.reploop.parser.protobuf.tree.DoubleValue;
import org.reploop.parser.protobuf.tree.EnumField;
import org.reploop.parser.protobuf.tree.Enumeration;
import org.reploop.parser.protobuf.tree.Extend;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.FloatValue;
import org.reploop.parser.protobuf.tree.Function;
import org.reploop.parser.protobuf.tree.Header;
import org.reploop.parser.protobuf.tree.Include;
import org.reploop.parser.protobuf.tree.IntValue;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.tree.Namespace;
import org.reploop.parser.protobuf.tree.Option;
import org.reploop.parser.protobuf.tree.OptionPair;
import org.reploop.parser.protobuf.tree.Options;
import org.reploop.parser.protobuf.tree.Pair;
import org.reploop.parser.protobuf.tree.ProtoProgram;
import org.reploop.parser.protobuf.tree.Service;
import org.reploop.parser.protobuf.tree.StringValue;
import org.reploop.parser.protobuf.tree.StructValue;
import org.reploop.parser.protobuf.tree.SyntaxPair;
import org.reploop.parser.protobuf.tree.Value;
import org.reploop.parser.protobuf.type.BoolType;
import org.reploop.parser.protobuf.type.ByteStringType;
import org.reploop.parser.protobuf.type.ByteType;
import org.reploop.parser.protobuf.type.CollectionType;
import org.reploop.parser.protobuf.type.DoubleType;
import org.reploop.parser.protobuf.type.FieldType;
import org.reploop.parser.protobuf.type.FloatType;
import org.reploop.parser.protobuf.type.IntType;
import org.reploop.parser.protobuf.type.ListType;
import org.reploop.parser.protobuf.type.LongType;
import org.reploop.parser.protobuf.type.MapType;
import org.reploop.parser.protobuf.type.SetType;
import org.reploop.parser.protobuf.type.ShortType;
import org.reploop.parser.protobuf.type.StringType;
import org.reploop.parser.protobuf.type.StructType;

/**
 * Protobuf AST visitor.
 *
 * @author George Cao(georgecao@outlook.com)
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

    public R visitSyntaxPair(SyntaxPair node, C context) {
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

    public R visitExtend(Extend node, C context) {
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

    public R visitDoubleValue(DoubleValue node, C context) {
        return visitNode(node, context);
    }

    public R visitFloatValue(FloatValue node, C context) {
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
