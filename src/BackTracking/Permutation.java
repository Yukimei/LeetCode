package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0, nums.length, res);
        return res;
    }
    private void dfs(int[] nums, int cur, int end, List<List<Integer>> res) {
        if (cur == end) {
            res.add(getList(nums));
            return;
        }
        for (int i = cur; i < end; i++) {
            replace(nums, i, cur);
            dfs(nums, cur + 1, end, res);
            replace(nums, i, cur);
        }
    }
    private void replace(int[] n, int j, int k) {
        int tmp = n[j];
        n[j] = n[k];
        n[k] = tmp;
    }
    private List<Integer> getList(int[] nums) {
    	List<Integer> res = new ArrayList<>();
    	for(int n : nums) {
    		res.add(n);
    	}
    	return res;
    }
}
