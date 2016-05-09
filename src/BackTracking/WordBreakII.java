package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//记得预处理啊！！
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<>();
		if (s == null) {
			return res;
		}
        boolean[][] isWord = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                isWord[i][j] = wordDict.contains(word);
            }
        }
        
		boolean[] possible = new boolean[s.length() + 1];
		possible[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (possible[j] && isWord[j][i - 1]) {
					possible[i] = true;
					break;
				}
			}
		}
		if (!possible[s.length()]) {
		    return res;
		}
		dfs2(s, 0, new ArrayList<Integer>(), res, isWord, possible);
		return res;
	}

	private void dfs2(String s, int idx, List<Integer> path, List<String> res, boolean[][] isWord, boolean[] possible) {
		if (idx == s.length()) {
			StringBuilder sb = new StringBuilder();
			int prevIdx = 0;
			for (int n : path) {
				sb.append(s.substring(prevIdx, n));
				if (n != s.length()) {
					sb.append(" ");
				}
				prevIdx = n;
			}
			res.add(sb.toString());
			return;
		}
		for (int i = idx; i < s.length(); i++) {
			if (isWord[idx][i] && possible[i + 1]) {
				path.add(i + 1);
				dfs2(s, i + 1, path, res, isWord, possible);
				path.remove(path.size() - 1);
			}
		}
	}
	
	// solution 2 : use map to utilize previous substrings
	// use this method when word dictionary size is small
	public List<String> wordBreak2(String s, Set<String> wordDict) {
	    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       

	// DFS function returns an array including all substrings derived from s.
	List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);

	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}  

	public List<String> wordBreak3(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<>();
		if (s == null) {
			return res;
		}
		dfs(s, 0, 0, s.length(), "", wordDict, res);
		return res;
	}

	private void dfs(String s, int from, int to, int end, String prev, Set<String> set, List<String> res) {
		if (to == end) {
			res.add(prev);
			return;
		}
		String scur = s.substring(from, to + 1);
		if (set.contains(scur)) {
			if (prev.length() != 0) {
				prev += " ";
			}
			dfs(s, to + 1, to + 1, end, prev + scur, set, res);
		}
		dfs(s, from, to + 1, end, prev, set, res);
	}
}
