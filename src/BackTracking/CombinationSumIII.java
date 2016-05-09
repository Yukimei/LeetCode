package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, k, n, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int i, int k, int n,List<Integer> ans, List<List<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(ans));
            return;
        } else if (k <= 0 || n <= 0) {
            return;
        }
        for (int j = i; j <= 9 ; j++) {
            ans.add(j);
            dfs(j + 1, k - 1, n - j, ans, res);
            ans.remove(ans.size() - 1);
        }
    }
}
