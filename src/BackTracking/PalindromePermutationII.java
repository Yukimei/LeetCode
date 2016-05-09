package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        Character alone = null;
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                sb.append(c);
                set.remove(c);
            }
        }
        if (set.size() > 1) {
            return res;
        }
        if (set.size() == 1) {
            alone = set.iterator().next();
        }
        helpBuild(sb.toString().toCharArray(), 0, alone, res);
        return res;
    }
    private void helpBuild(char[] s, int start, Character alone, List<String> res) {
        if (start == s.length) {
            String tmp = new String(s);
            res.add(tmp + (alone == null ? "" : alone) + new StringBuilder(tmp).reverse().toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i < s.length; i++) {
            if (set.contains(s[i])) {
                continue;
            }
            set.add(s[i]);
            swap(s, i, start);
            helpBuild(s, start + 1, alone, res);
            swap(s, i, start);
        }
    }
    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
