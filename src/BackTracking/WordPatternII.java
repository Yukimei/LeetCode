package BackTracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/// key is try every possibilities  (from i to length - 1 of each level of each pattern char) 
///  (then dfs to deeper level) at the same time, if the pattern char appears again, 
// check whether the substring matches the pattern word in map
// 1. use map and set to record the already appeared pattern and relation
// 2. check whether already in map/set in each call
// 3. base case is moth indexes reach the end (true)   or  either reach the end(false)
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null || pattern.length() > str.length()) {
            return false;
        }
        // start dfs, from 0 in both string
        // set use to record all pattern words, map record pattern, word relation
        return dfs(pattern, 0, str, 0, new HashSet<String>(), new HashMap<Character, String>());
    }
    private boolean dfs(String pattern, int i, String str, int j, Set<String> set, Map<Character, String> map) {
        // both reach end
    	if (i == pattern.length() && j == str.length()) {
            return true;
        }
        // either one reach end first
        if (i == pattern.length() || j == str.length()) {
            return false;
        }
        // current pattern character
        char c = pattern.charAt(i);
        // the pattern exist before, so get the word out
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (str.startsWith(s, j)) { // if the following match the pattern word
            							// the current dfs can continue;
                return dfs(pattern, i + 1, str, j + s.length(), set, map);
            } else {
                return false;  // the following doesnot match the pattern word, so cut the dfs
                				// 剪枝
            }
        }
        // try all posibilities
        for (int k = j; k < str.length(); k++) {
            String s = str.substring(j, k + 1);
            
            // if check whether add to pattern matching before
            if (set.contains(s)) {
                continue;
            }
            // add to map and set
            map.put(c, s);
            set.add(s);
            
            if (dfs(pattern, i + 1, str, k + 1, set, map)) {
                return true;
            }
            // posibility out, remove from map and set
            map.remove(c);
            set.remove(s);
        }
        return false;
    }
}
