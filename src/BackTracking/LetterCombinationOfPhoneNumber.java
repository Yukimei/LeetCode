package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        sb.append("");
        dfs(digits, 0, digits.length(), sb, map, res);
        return res;
    }
    private void dfs(String digit, int i, int end, StringBuilder sb, String[] map, List<String> res) {
        if (i == end) {
            res.add(sb.toString());
            return;
        }
        int idx = digit.charAt(i) - '0';
        for (char c : map[idx].toCharArray()) {
            sb.append(c);
            dfs(digit, i + 1, end, sb, map, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
