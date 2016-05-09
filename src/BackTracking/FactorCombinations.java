package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 2, new ArrayList<Integer>(), res);
        return res;
    }
    private void dfs(int n, int factor, List<Integer> ans, List<List<Integer>> res) {
        for (int i = factor; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                ans.add(i);
                ans.add(n / i);
                //key is to add all factors start from current
                res.add(new ArrayList<Integer>(ans));
                ans.remove(ans.size() - 1);
                //add all factors start from current
                dfs( n / i, i, ans, res);
                ans.remove(ans.size() - 1);
            }
        }
    }   
}
