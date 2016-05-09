package Google;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
    private static final String[] number = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        dfs(digits, 0, sb, res);
        return res;
    }
    private void dfs (String digits, int i, StringBuilder sb, List<String> res) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : number[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            dfs(digits, i + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}