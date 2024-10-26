package org.reploop.parser.protobuf.generator;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;

import org.reploop.parser.Classpath;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;

import org.apache.commons.lang3.StringUtils;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-09-28 20
 */
public class ProtobufServiceResolver extends AstVisitor<Node, Classpath<ProtoProgram>> {

	private final Set<Service> services = new HashSet<>();

	@Override
	public Node visitNode(Node node, Classpath<ProtoProgram> context) {
		return node;
	}

	private static final Splitter COMMA_SPLITTER = Splitter.on(",").omitEmptyStrings().trimResults();

	private final Map<QualifiedName, Function> functions = new HashMap<>();

	@Override
	public Message visitMessage(Message node, Classpath<ProtoProgram> context) {
		List<Option> options = node.getOptions();
		if (null != options && !options.isEmpty()) {
			List<String> methods = new ArrayList<>();
			FieldType requestType = null, responseType = null;
			for (Option option : options) {
				if (option instanceof OptionPair) {
					OptionPair pair = (OptionPair) option;
					String attr = pair.getAttr();
					Value value = pair.getValue();
					switch (attr) {
						case "method_name":
							StringValue val = (StringValue) value;
							String ms = StringUtils.strip(val.getValue(), "\"");
							Iterable<String> it = COMMA_SPLITTER.split(ms);
							it.forEach(methods::add);
							break;
						case "type":
							StructValue struct = (StructValue) value;
							String type = struct.getName().suffix();
							FieldType theType = new StructType(node.getName());
							switch (type) {
								case "REQUEST":
									requestType = theType;
									break;
								case "RESPONSE":
									responseType = theType;
									break;
							}
							break;
					}

				}
			}
			if (null == requestType && null == responseType) {
				return node;
			}
			for (String method : methods) {
				QualifiedName fn = QualifiedName.of(method);
				Function func = functions.get(fn);
				if (null == func) {
					func = new Function(fn, requestType, responseType, Collections.emptyList());
				}
				else {
					func = new Function(fn, orElse(requestType, func.getRequestType()),
							orElse(responseType, func.getResponseType()), func.getOptions());
				}
				functions.put(fn, func);
			}

		}
		return node;
	}

	private FieldType orElse(FieldType fieldType, FieldType defaultValue) {
		return null != fieldType ? fieldType : defaultValue;
	}

	@Override
	public ProtoProgram visitProtobufProgram(ProtoProgram node, Classpath<ProtoProgram> context) {
		services.clear();
		functions.clear();
		List<Message> messages = node.getMessages();
		if (null != messages) {
			// Visit all messages
			messages.forEach(message -> visitMessage(message, context));
			if (!functions.isEmpty()) {
				ProtoProgram program = context.entity(context.current());
				QualifiedName name = QualifiedName.of(program.getOuterClassName());
				Service service = null;
				for (Service candidate : services) {
					if (candidate.getName().endsWith(name)) {
						service = candidate;
					}
				}
				if (null == service) {
					service = new Service(name, Collections.emptyList(), new ArrayList<>(functions.values()));
					services.add(service);
				}
				else {
					service.getFunctions().addAll(functions.values());
				}
			}
			// If we find any service definitions
			if (!services.isEmpty()) {
				ImmutableList.Builder<Service> sb = new ImmutableList.Builder<>();
				List<Service> list = node.getServices();
				if (null != list) {
					sb.addAll(node.getServices());
				}
				sb.addAll(services);
				ProtoProgram pp = new ProtoProgram(node.getComments(), node.getOptions(), node.getHeaders(),
						node.getMessages(), node.getEnumerations(), sb.build());
				pp.setFile(node.getFile());
				pp.setOuterClassName(node.getOuterClassName());
				return pp;
			}
		}
		return node;
	}

}
