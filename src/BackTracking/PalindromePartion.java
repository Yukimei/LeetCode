package BackTracking;

import java.util.ArrayList;
import java.util.List;
//use dp to record palindrome partion indexes
//back track for every possible solutions
public class PalindromePartion {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j) {
					isPalindrome[j][i] = true;
				} else if (j == i - 1 && s.charAt(i) == s.charAt(j)) {
					isPalindrome[j][i] = true;
				} else if (j < i - 1 && s.charAt(i) == s.charAt(j) && isPalindrome[j + 1][i - 1]) {
					isPalindrome[j][i] = true;
				}
			}
		}

		dfs(s, 0, isPalindrome, new ArrayList<String>(), res);
		return res;
	}

	private void dfs(String s, int i, boolean[][] isPalindrome, List<String> ans, List<List<String>> res) {
		if (i == s.length()) {
			res.add(new ArrayList<>(ans));
			return;
		}

		for (int j = i; j < s.length(); j++) {
			if (isPalindrome[i][j]) {
				ans.add(s.substring(i, j + 1));
				dfs(s, j + 1, isPalindrome, ans, res);
				ans.remove(ans.size() - 1);
			}
		}
	}
}
