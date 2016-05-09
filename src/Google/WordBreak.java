package Google;

import java.util.Set;

//key is to use dp.
//j always is at least 1 smaller than i, so it would be easy to substring
// for every inner loop (for substring(j, i)) if one succeed, break, so loop to i + 1
public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || wordDict == null || s.length() == 0 || wordDict.size() == 0) {
			return false;
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
