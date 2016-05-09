package Google;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

//for every foreach , check if the map contains it , otherwise it would cause a nullpointer exception.
public class AlienDictionary {
	public String alienOrder(String[] words) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		Map<Character, Integer> indegree = new HashMap<>();
		// innit indegree
		for (String w : words) {
			for (char c : w.toCharArray()) {
				indegree.put(c, 0);
			}
		}

		// innit graph and add edges
		for (int i = 0; i < words.length - 1; i++) {
			String w1 = words[i];
			String w2 = words[i + 1];
			for (int j = 0; j < w1.length() && j < w2.length(); j++) {
				char c1 = w1.charAt(j);
				char c2 = w2.charAt(j);
				if (c1 != c2) {
					if (!graph.containsKey(c1)) {
						graph.put(c1, new HashSet<>());
					}
					if (graph.get(c1).add(c2)) {
						indegree.put(c2, indegree.get(c2) + 1);
					}
				}
			}
		}

		// innit queue an push all 0-indegree node into queue
		Deque<Character> queue = new LinkedList<>();
		for (char c : indegree.keySet()) {
			if (indegree.get(c) == 0) {
				queue.offerFirst(c);
			}
		}

		// get order and save to result;
		StringBuilder res = new StringBuilder();
		while (!queue.isEmpty()) {
			char c = queue.pollLast();
			res.append(c);
			if (graph.containsKey(c)) {
				for (char next : graph.get(c)) {
					indegree.put(next, indegree.get(next) - 1);
					if (indegree.get(next) == 0) {
						queue.offerFirst(next);
					}
				}
			}
		}
		return res.length() == indegree.size() ? res.toString() : "";
	}
}