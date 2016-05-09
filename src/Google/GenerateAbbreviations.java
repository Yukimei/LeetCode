package Google;

import java.util.ArrayList;
import java.util.List;

public class GenerateAbbreviations {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		if (word == null) {
			return res;
		}
		dfs(0, 0, "", word, res);
		return res;
	}

	private void dfs(int i, int count, String str, String word, List<String> res) {
		if (i == word.length()) {
			if (count == 0) {
				res.add(str);
			} else {
				res.add(str + count);
			}
			return;
		}
		char c = word.charAt(i);
		if (count != 0) {
			dfs(i + 1, 0, str + count + c, word, res);
		} else {
			dfs(i + 1, count, str + c, word, res);
		}
		dfs(i + 1, count + 1, str, word, res);
	}
}