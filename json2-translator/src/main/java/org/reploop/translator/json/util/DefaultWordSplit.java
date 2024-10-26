package org.reploop.translator.json.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class DefaultWordSplit implements WordSplit {

	private static final State START = new State(0);

	private static final State END = new State(Integer.MAX_VALUE);

	private final Map<State, Map<Character, State>> stateTransit = new HashMap<>();

	private final Comparator<List<String>> sizeComparator = Comparator
		.comparingInt((ToIntFunction<List<String>>) List::size)
		.reversed();

	private final Comparator<List<String>> countComparator = Comparator.comparingInt(this::count);

	private final Comparator<List<String>> cmp = countComparator.thenComparing(sizeComparator);

	private int i = 0;

	public DefaultWordSplit() {
		init();
	}

	private static String name(State state) {
		return "s" + state.label;
	}

	public void print() {
		dot();
	}

	public void dot() {
		StringBuilder sb = new StringBuilder();
		sb.append("digraph trie {").append("\r\n");
		sb.append("rankdir=LR;").append("\r\n");
		sb.append("node [shape = circle];").append("\r\n");
		stateTransit.values()
			.stream()
			.flatMap(m -> m.values().stream())
			.filter(State::isFinalState)
			.sorted(Comparator.comparingInt(o -> o.label))
			.distinct()
			.forEach(new Consumer<State>() {
				@Override
				public void accept(State state) {
					sb.append(name(state)).append(" ").append("[shape = doublecircle];\r\n");
				}
			});
		sb.append("\r\n");
		stateTransit.forEach(new BiConsumer<>() {
			@Override
			public void accept(State from, Map<Character, State> next) {
				next.forEach(new BiConsumer<>() {
					@Override
					public void accept(Character c, State to) {
						sb.append(name(from))
							.append(" -> ")
							.append(name(to))
							.append(" [ label = ")
							.append(c)
							.append(" ];")
							.append("\r\n");
					}
				});
			}
		});
		sb.append("}");
		System.out.println(sb);
	}

	private void build(String word) {
		CharacterIterator it = new StringCharacterIterator(word);
		State curr = START;
		for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
			Map<Character, State> stateMap = stateTransit.computeIfAbsent(curr, state -> new HashMap<>());
			curr = stateMap.computeIfAbsent(c, character -> new State(++i));
		}
		curr.setFinalState(true);
	}

	private void init() {
		try {
			build();
		}
		catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void build() throws IOException, URISyntaxException {
		WordDict.loadDefaultWords().forEach(this::build);
	}

	public void load(String resource) throws IOException, URISyntaxException {
		WordDict.load(resource).forEach(this::build);
	}

	@Override
	public List<String> parseWords(String org) {
		List<String> words = Collections.emptyList();
		List<String> match = Collections.emptyList();
		for (int m = 0; m < org.length(); m++) {
			String prefix = null;
			String suffix = org;
			if (0 != m) {
				prefix = org.substring(0, m);
				suffix = org.substring(m);
			}
			List<String> splits = split(suffix);
			int res = cmp.compare(splits, match);
			if (res > 0) {
				List<String> parts = new ArrayList<>(splits.size() + 2);
				if (null != prefix) {
					parts.add(prefix);
				}
				parts.addAll(splits);
				int count = count(splits);
				if (suffix.length() != count) {
					parts.add(suffix.substring(count));
				}
				match = splits;
				words = parts;
			}
		}
		if (words.isEmpty()) {
			words = Collections.singletonList(org);
		}
		return words;
	}

	private int count(List<String> l) {
		return l.stream().mapToInt(String::length).sum();
	}

	/**
	 * Find all prefixes consists of match words.
	 * @param org the original string
	 * @return longest prefix match the input string
	 */
	private List<String> split(String org) {
		List<String> splits = getPrefix(org);
		if (splits.isEmpty()) {
			return Collections.emptyList();
		}
		List<String> words = new ArrayList<>();
		for (String prefix : splits) {
			List<String> prefixes = new ArrayList<>();
			prefixes.add(prefix);
			String suffix = org.substring(prefix.length());
			if (0 != suffix.length()) {
				List<String> left = split(suffix);
				prefixes.addAll(left);
			}
			int res = cmp.compare(prefixes, words);
			if (res > 0)
				words = prefixes;
		}
		return words;
	}

	/**
	 * Find match prefixes.
	 * @param org the original string
	 * @return all match prefixes.
	 */
	private List<String> getPrefix(String org) {
		CharacterIterator it = new StringCharacterIterator(org);
		State curr = START;
		List<String> splits = new ArrayList<>();
		for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
			Map<Character, State> stateMap = stateTransit.getOrDefault(curr, Collections.emptyMap());
			State next = stateMap.get(c);
			if (null == next) {
				break;
			}
			if (next.isFinalState()) {
				splits.add(org.substring(0, it.getIndex() + 1));
			}
			curr = next;
		}
		return splits;
	}

	private static class State {

		private final int label;

		private boolean finalState = false;

		public State(int label) {
			this.label = label;
		}

		public int getLabel() {
			return label;
		}

		public boolean isFinalState() {
			return finalState;
		}

		public void setFinalState(boolean finalState) {
			this.finalState = finalState;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			State state = (State) o;
			return Objects.equals(label, state.label);
		}

		@Override
		public int hashCode() {
			return Objects.hash(label);
		}

		@Override
		public String toString() {
			return "State{" + "label=" + label + ", finalState=" + finalState + '}';
		}

	}

}