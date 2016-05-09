package BackTracking;

import java.util.ArrayList;
import java.util.List;
//because it is backtracking, use char array to replace it is more convenient
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] v = new boolean[n];
        boolean[] s1 = new boolean[2 * n - 1];
        boolean[] s2 = new boolean[2 * n - 1];
        List<String> ans = new ArrayList<>();
        dfs(n,0, v, s1, s2,ans, res);
        return res;
    }
    private void dfs(int n,int level, boolean[] v, boolean[] s1, boolean[] s2, List<String> ans, List<List<String>> res) {
        if (level == n) {
            res.add(new ArrayList<>(ans));
            return;
        }
        char[] str = new char[n];
        innit(str);
        for (int i = 0; i < n ; i++) {
            if ( v[i] || s1[level + i] || s2[level + (n - i - 1)]) {
                continue;
            } else {
                str[i] = 'Q';
                ans.add(new String(str));
                v[i] = true;
                s1[level + i] = true;
                s2[level + (n - i - 1)] = true;
                dfs(n, level + 1, v, s1, s2, ans, res);
                str[i] = '.';
                ans.remove(ans.size() - 1);
                v[i] = false;
                s1[level + i] = false;
                s2[level + (n - i - 1)] = false;
            }
        }
    }
    private void innit(char[] s) {
        for (int i = 0; i < s.length; i++) {
            s[i] = '.';
        }
    }
    public static void main(String[] args) {
    	NQueen nq = new NQueen();
    	List<List<String>> res = nq.solveNQueens(7);
    	for (List<String> list : res) {
    		for (String s : list) {
    			System.out.println(s);
    		}
    		System.out.println("********");
    	}
    }
}
