package org.reploop.translator.json.util;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WordTreeTest {

	WordTree wt;

	@Before
	public void setUp() {
		wt = new WordTree("/ws.txt");
	}

	@Test
	public void words() {
		List<String> words = wt.parseWords("thankyouandyou");
		assertThat(words).isNotEmpty();
		System.out.println(words);
	}

	@Test
	public void tree() throws IOException {
		wt.print();
	}

	@Test
	public void testTree() {
	}

}