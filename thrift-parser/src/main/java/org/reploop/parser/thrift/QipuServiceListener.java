package org.reploop.parser.thrift;

import com.google.common.base.CaseFormat;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.reploop.parser.thrift.base.ThriftBaseBaseListener;
import org.reploop.parser.thrift.base.ThriftBaseParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-03-06 10
 */
public class QipuServiceListener extends ThriftBaseBaseListener {
    private static final Logger LOG = LoggerFactory.getLogger(QipuServiceListener.class);

    Map<String, StringBuilder> serviceImplMap = new HashMap<String, StringBuilder>();
    StringBuilder current = new StringBuilder();

    @Override
    public void enterInclude(@NotNull ThriftBaseParser.IncludeContext ctx) {
        super.enterInclude(ctx);
    }

    @Override
    public void exitInclude(@NotNull ThriftBaseParser.IncludeContext ctx) {
        System.out.println(ctx.LITERAL().getText());
    }

    @Override
    public void enterService(@NotNull ThriftBaseParser.ServiceContext ctx) {
        TerminalNode serviceNode = ctx.ID(0);
        String service = serviceNode.getText() + "Adapter";
        current.append("public class ")
                .append(service)
                .append(" extends ServiceAdapter<")
                .append(serviceNode.getText())
                .append(".Client>").append("{\r\n");

    }


    @Override
    public void enterFunction(@NotNull ThriftBaseParser.FunctionContext ctx) {
        ThriftBaseParser.FieldContext field = ctx.field(0);
        String param = field.ID().getText();
        String funcName = ctx.ID().getText();
        // Request type
        String type = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, param);
        String paramName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, param);
        // Response type
        String response = type.replace("Request", "Response");
        String candidate = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, funcName) + "Response";


        current.append(response).append(" ").append(candidate).append(" ")
                .append(funcName)

                .append("(")
                .append(type)
                .append(" ")
                .append(paramName)
                .append(") throws InvalidProtocolBufferException, TException {\r\n");

        current.append("ByteBuffer buff = ByteBuffer.wrap(").append(paramName).append(".toByteArray());\r\n")
                .append("Connection<TTransport, InetSocketAddress> conn = getConnection();")
                .append("try {")
                .append("buff = newClient(conn).").append(funcName).append("(buff);")
                .append("success(conn);")
                .append("return ").append(response).append(".parseFrom(buff.array());")
                .append("} catch (TException e) {")
                .append("fail(conn, e);")
                .append("throw e;")
                .append("}");
    }

    @Override
    public void exitFunction(@NotNull ThriftBaseParser.FunctionContext ctx) {
        current.append("}").append("\r\n");
    }

    @Override
    public void exitService(@NotNull ThriftBaseParser.ServiceContext ctx) {

        TerminalNode serviceNode = ctx.ID(0);
        current.append("}");
        serviceImplMap.put(serviceNode.getText(), current);
        System.out.println(current);
        current = new StringBuilder();
    }
}
