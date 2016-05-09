package Google;
//star tracks the starting index of p (in the backtracking)
//match tracks the starting index if s(in the backtracking)
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int si = 0, pi = 0, star = -1, match = 0;
        while (si < s.length()) {
            if (pi < p.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
                pi++;
                si++;
            } else if (pi < p.length() && p.charAt(pi) == '*') {
                match = si;
                star = pi;
                pi++;
            } else if (star != -1) {
                // star is to mark star index (the beginning of each backtracking process)
                pi = star + 1;// * match more letter than previous loop (a backtracking process)
                si = match++;
            } else {
                return false;
            }
        }
        while(pi < p.length() && p.charAt(pi) == '*') {
            pi++;
        }
        return pi == p.length();
    }
}