package org.reploop.parser.commons;

/**
 * Levenshtein Distance .
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-12 14
 */
public class LevenshteinDistance {

	public static int compute(String s0, String s1) {
		int len0 = s0.length() + 1;
		int len1 = s1.length() + 1;

		// the array of distances
		int[] cost = new int[len0];
		int[] newCost = new int[len0];

		// initial cost of skipping prefix in String s0
		for (int i = 0; i < len0; i++) {
			cost[i] = i;
		}

		// dynamically computing the array of distances

		// transformation cost for each letter in s1
		for (int j = 1; j < len1; j++) {
			// initial cost of skipping prefix in String s1
			newCost[0] = j;

			// transformation cost for each letter in s0
			for (int i = 1; i < len0; i++) {
				// matching current letters in both strings
				int match = (s0.charAt(i - 1) == s1.charAt(j - 1)) ? 0 : 1;

				// computing cost for each transformation
				int costReplace = cost[i - 1] + match;
				int costInsert = cost[i] + 1;
				int costDelete = newCost[i - 1] + 1;

				// keep minimum cost
				newCost[i] = Math.min(Math.min(costInsert, costDelete), costReplace);
			}

			// swap cost/newCost arrays
			int[] swap = cost;
			cost = newCost;
			newCost = swap;
		}

		// the distance is the cost for transforming all letters in both strings
		return cost[len0 - 1];
	}

}
