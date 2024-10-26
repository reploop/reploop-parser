package org.reploop.parser.commons;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-05-16 23
 */
public class LevenshteinDistanceTest {

	@Test
	public void testDistance() throws Exception {
		int d = LevenshteinDistance.compute("2", "2");
		assertEquals(0, d);
	}

	@Test
	public void testDistance1() throws Exception {
		int d = LevenshteinDistance.compute("If", "if");
		assertEquals(1, d);

		d = LevenshteinDistance.compute("fi", "config");
		System.out.println(d);

		d = LevenshteinDistance.compute("distance", "ce");
		System.out.println(d);
	}

}
