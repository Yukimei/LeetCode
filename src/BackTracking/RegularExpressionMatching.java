package BackTracking;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null ) {
            return false;
        }
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int k = 1; 2 * k <= p.length(); k++) {
            if (p.charAt(2 * k - 1) == '*') {
                match[0][2 * k] = match[0][2 * k - 2];
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    if (match[i][j - 2]) {
                        match[i][j] = true;
                        continue;
                    }
                    if (match[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                        match[i][j] = true;
                    }
                } else if (match[i - 1][j - 1] && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                    match[i][j] = true;
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
