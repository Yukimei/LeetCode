package Google;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("");
		dfs(0, 0, n, sb, res);
		return res;
	}

	private void dfs(int l, int r, int n, StringBuilder sb, List<String> res) {
		if (l == n && r == n) {
			res.add(sb.toString());
			return;
		}
		if (l < n) {
			sb.append("(");
			dfs(l + 1, r, n, sb, res);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (r < l) {
			sb.append(")");
			dfs(l, r + 1, n, sb, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}