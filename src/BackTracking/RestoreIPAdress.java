package BackTracking;

import java.util.ArrayList;
import java.util.List;

//像这种backtracking类的题目还是直接用string + 这样子删的时候比较方便
//记得处理 count > 4的情况， 因为IP只能分成四部分
//处理大于255的情况
//处理最后一位 加 "."的情况
public class RestoreIPAdress {
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		if (s == null || s.length() < 4) {
			return list;
		}

		dfs(s, 0, "", list, 0);
		return list;
	}

	private void dfs(String s, int i, String ans, List<String> res, int count) {
		if (i == s.length() && count == 4) {
			res.add(ans);
			return;
		} else if (count > 4 || i > s.length() - 1) {
			return;
		}

		if (s.charAt(i) != '0') {
			for (int j = 0; j < 3 && i + j < s.length(); j++) {
				String numStr = s.substring(i, i + j + 1);
				int num = Integer.parseInt(numStr);
				if (num <= 255) {
					if (i + j < s.length() - 1) {
						dfs(s, i + j + 1, ans + numStr + ".", res, count + 1);

					} else {
						dfs(s, i + j + 1, ans + numStr, res, count + 1);
					}
				}
			}
		} else {
			if (i != s.length() - 1) {
				dfs(s, i + 1, ans + "0.", res, count + 1);
			} else {
				dfs(s, i + 1, ans + "0", res, count + 1);
			}
		}
	}

	public static void main(String[] args) {
		RestoreIPAdress r = new RestoreIPAdress();
		String s = "12345";
		List<String> res = r.restoreIpAddresses(s);
		for (String ss : res) {
			System.out.println(ss);
		}
	}
}
