package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		if (beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null
				|| wordList.size() == 0) {
			return res;
		}
		Map<String, List<String>> map = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();

		bfs(beginWord, endWord, wordList, map, distance);

		if (!map.containsKey(endWord)) {
			return res;
		}
		List<String> path = new ArrayList<>();
		path.add(endWord);
		dfs(endWord, beginWord, map, distance, path, res);
		return res;
	}

	private void bfs(String start, String end, Set<String> set, Map<String, List<String>> map,
			Map<String, Integer> distance) {
		Deque<String> queue = new LinkedList<>();
		queue.offer(start);
		distance.put(start, 0);
		int depth = 0;
		boolean flag = false;
		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				for (String next : getLadders(cur, set)) {
					if (!map.containsKey(next)) { // map是用于记录所有前缀（可能路程相等的时候最短路径有多条，
													// 此时所有前缀都需要记录，但queue只需要进入一次
						map.put(next, new ArrayList<>());
					}
					map.get(next).add(cur);
					// 注意这个distance是用来控制它只进queue一次
					if (distance.containsKey(next)) {
						continue;
					}
					distance.put(next, depth);
					queue.offer(next);

					if (next.equals(end)) {
						flag = true;
					}
				}
			}
			if (flag) {
				return;
			}
		}
	}

	private void dfs(String cur, String end, Map<String, List<String>> map, Map<String, Integer> distance,
			List<String> path, List<List<String>> res) {
		if (cur.equals(end)) {
			Collections.reverse(path);
			res.add(new ArrayList<>(path));
			Collections.reverse(path);
			return;
		}
		for (String next : map.get(cur)) {
			if (distance.get(next) == distance.get(cur) - 1) {
				path.add(next);
				dfs(next, end, map, distance, path, res);
				path.remove(path.size() - 1);
			}
		}
	}

	private List<String> getLadders(String word, Set<String> wordList) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				if (j != word.charAt(i)) {
					String candidate = replace(word, i, j);
					if (wordList.contains(candidate)) {
						list.add(candidate);
					}
				}
			}
		}
		return list;
	}

	private static String replace(String word, int i, char c) {
		char[] chars = word.toCharArray();
		chars[i] = c;
		return new String(chars);
	}
}