package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//key is to use map to store the substring S and the list of break possible for S
//so for current word equals all following possbility CONCAT current word
//use Map<String, List<String>>
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		return dfs(s, wordDict, new HashMap<String, List<String>>());
	}

	private List<String> dfs(String s, Set<String> set, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> res = new ArrayList<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : set) {
			if (s.startsWith(word)) {
				List<String> subList = dfs(s.substring(word.length()), set, map);
				for (String sub : subList) {
					res.add(word + (sub.length() == 0 ? "" : " ") + sub);
				}
			}
		}
		map.put(s, res);
		return res;
	}
}