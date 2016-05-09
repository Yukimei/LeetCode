package BackTracking;

// key here is to use while loop to imitate the recursion stack
// use index (star and match) to record where the back tracking starting point is (the recusion back position)
// compare to recusion stack, this is need to consider each breaking point (in stack the system do this for you)
// check index is inbound in every process
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		int si = 0, pi = 0, match = 0, star = -1;
		while (si < s.length()) {
			if (pi < p.length() && (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))) {
				si++;
				pi++;
			} else if (pi < p.length() && p.charAt(pi) == '*') {
				star = pi;
				pi++;
				match = si;
			} else if (star != -1) {
				// star is to mark star index (the beginning of each
				// backtracking process)
				pi = star + 1;
				match++; // * match more letter than previous loop (a
							// backtracking process)
				si = match;
			} else {
				return false;
			}
		}
		while (pi < p.length() && p.charAt(pi) == '*') {
			pi++;
		}
		return pi == p.length();
	}
}
