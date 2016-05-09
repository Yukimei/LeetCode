package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(0, candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
    private void dfs(int i, int[] num, int sum, int target, List<Integer> ans, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(ans));
        } else if (sum > target) {
            return;
        }
        for (int j = i; j < num.length; j++) {
            if (j > i && num[j - 1] == num[j]) {
                continue;
            }
            ans.add(num[j]);
            dfs(j + 1, num, sum + num[j],target, ans , res);
            ans.remove(ans.size() - 1);
            
        }
    } 
}
