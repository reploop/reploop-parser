package org.reploop.parser.protobuf.tree;

import com.qiyi.walle.parser.protobuf.AstVisitor;
import com.qiyi.walle.parser.protobuf.Node;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 10
 */
public class ProtoProgram extends Node {
    private String outerClassName;
    private Path file;
    private List<String> comments;
    private List<Option> options;
    private List<Header> headers;
    private List<Message> messages;
    private List<Enumeration> enumerations;
    private List<Service> services;

    public ProtoProgram(List<String> comments,
                        List<Option> options,
                        List<Header> headers,
                        List<Message> messages,
                        List<Enumeration> enumerations,
                        List<Service> services) {
        this.messages = messages;
        this.services = services;
        this.enumerations = enumerations;
        this.headers = headers;
        this.options = options;
        this.comments = comments;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitProtobufProgram(this, context);
    }

    public List<Option> getOptions() {
        return options;
    }

    public List<String> getComments() {
        return comments;
    }

    public Path getFile() {
        return file;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<Enumeration> getEnumerations() {
        return enumerations;
    }

    public void setFile(Path file) {
        this.file = file;
    }


    public String getOuterClassName() {
        return outerClassName;
    }

    public void setOuterClassName(String outerClassName) {
        this.outerClassName = outerClassName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtoProgram protoProgram = (ProtoProgram) o;
        return Objects.equals(headers, protoProgram.headers) &&
                Objects.equals(messages, protoProgram.messages) &&
                Objects.equals(services, protoProgram.services) &&
                Objects.equals(enumerations, protoProgram.enumerations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headers, messages, services, enumerations);
    }

    @Override
    public String toString() {
        return "ProtoProgram{" +
                "file=" + file +
                ", comments=" + comments +
                ", options=" + options +
                ", headers=" + headers +
                ", messages=" + messages +
                ", enumerations=" + enumerations +
                ", services=" + services +
                '}';
    }
}
