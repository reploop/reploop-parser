package org.reploop.parser.protobuf.generator;

import com.qiyi.walle.parser.protobuf.AstVisitor;
import com.qiyi.walle.parser.protobuf.Node;
import com.qiyi.walle.parser.protobuf.tree.*;

/**
 * Protobuf Schema AST visitor.
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-09 11
 */
public abstract class ProtobufAstVisitor<R, C> extends AstVisitor<R, C> {

    @Override
    public R visitNode(Node node, C context) {
        return null;
    }


}
