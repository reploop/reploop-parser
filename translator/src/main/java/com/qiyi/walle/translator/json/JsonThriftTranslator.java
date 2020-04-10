package com.qiyi.walle.translator.json;


import com.google.common.collect.ImmutableList;
import com.qiyi.walle.parser.Classpath;
import com.qiyi.walle.parser.json.AstVisitor;
import com.qiyi.walle.parser.json.Node;
import com.qiyi.walle.parser.json.tree.DoubleVal;
import com.qiyi.walle.parser.json.tree.LongVal;
import com.qiyi.walle.parser.json.tree.*;
import com.qiyi.walle.parser.thrift.tree.Entity;
import com.qiyi.walle.parser.thrift.tree.Header;
import com.qiyi.walle.parser.thrift.tree.ThriftProgram;

import java.nio.file.Path;
import java.util.List;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2017-01-23 19
 */
public class JsonThriftTranslator extends AstVisitor<Node, Classpath<ThriftProgram>> {
    private Path path;

    public JsonThriftTranslator(Path path) {
        this.path = path;
    }

    @Override
    public Node visitNode(Node node, Classpath<ThriftProgram> context) {
        return node;
    }


    @Override
    public Pair visitPair(Pair value, Classpath<ThriftProgram> context) {
        return new Pair(value.getKey(), visitValue(value.getValue(), context));
    }

    @Override
    public Value visitValue(Value value, Classpath<ThriftProgram> context) {
        ImmutableList.Builder<Header> hb = new ImmutableList.Builder<>();
        ImmutableList.Builder<Entity> eb = new ImmutableList.Builder<>();
        ThriftProgram program = new ThriftProgram(hb.build(), eb.build());
        context.entity(path, program);
        if (value instanceof Text) {
            return new Text(((Text) value).getVal());
        } else if (value instanceof Null) {
            return new Null();
        } else if (value instanceof Array) {
            Array array = (Array) value;
            List<Value> values = array.getValues();
            ImmutableList.Builder<Value> vb = new ImmutableList.Builder<>();
            for (Value val : values) {
                vb.add(visitValue(val, context));
            }
            return new Array(vb.build());
        } else if (value instanceof Bool) {
            return new Bool(((Bool) value).getVal());
        } else if (value instanceof LongVal) {
            return new LongVal(((LongVal) value).getVal());
        } else if (value instanceof DoubleVal) {
            return new DoubleVal(((DoubleVal) value).getVal());
        } else if (value instanceof com.qiyi.walle.parser.json.tree.Entity) {
            com.qiyi.walle.parser.json.tree.Entity entity = (com.qiyi.walle.parser.json.tree.Entity) value;
            List<Pair> pairs = entity.getPairs();
            ImmutableList.Builder<Pair> pb = new ImmutableList.Builder<>();
            for (Pair pair : pairs) {
                pb.add(visitPair(pair, context));
            }
            return new com.qiyi.walle.parser.json.tree.Entity(pb.build());
        }
        return value;
    }

    @Override
    public Json visitJson(Json json, Classpath<ThriftProgram> context) {
        return new Json(visitValue(json.getValue(), context));
    }
}
