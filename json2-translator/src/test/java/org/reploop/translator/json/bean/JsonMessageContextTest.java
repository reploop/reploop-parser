package org.reploop.translator.json.bean;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.reploop.parser.QualifiedName;

public class JsonMessageContextTest {

	private MessageContext context;

	@Before
	public void setUp() throws Exception {
		context = new MessageContext();
		String expected = "$.log.entries.response.content.text";
		context.configureJsonRawValue(expected);

	}

	@Test
	public void configure() {
		context.configureJsonRawValue(QualifiedName.of("3"));
	}

	@Test
	public void testHasDateFormat() {
		String fqn = "$.result.createTime";
		String pattern = "yyyy-MM-dd HH:mm:ss";
		context.configureDateFormat(QualifiedName.of(fqn), pattern);

		fqn = "$.result.createTime";
		Optional<String> o = context.hasDateFormat(QualifiedName.of(fqn));
		assertThat(o).isNotNull();
		assertThat(o.isPresent()).isTrue();
	}

	@Test
	public void isJsonRawValue() {
		assertThat(context.isJsonRawValue()).isFalse();
		String expected = "$.log.entries.response.content.text";
		assertThat(context.isJsonRawValue(QualifiedName.of(expected))).isTrue();
		expected = "$.log.entries.response.content";
		assertThat(context.isJsonRawValue(QualifiedName.of(expected))).isFalse();
		expected = "$.log.entries.response.content.text0";
		assertThat(context.isJsonRawValue(QualifiedName.of(expected))).isFalse();
		expected = "$0.log.entries.response.content.text";
		assertThat(context.isJsonRawValue(QualifiedName.of(expected))).isTrue();
		expected = "log.log.entries.response.content.text";
		assertThat(context.isJsonRawValue(QualifiedName.of(expected))).isTrue();
	}

}