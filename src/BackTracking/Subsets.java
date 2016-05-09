package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null) {
			return res;
		}
		List<Integer> ans = new ArrayList<>();
		Arrays.sort(nums);
		dfs(0, nums, ans, res);
		return res;
	}

	private void dfs(int start, int[] nums, List<Integer> ans, List<List<Integer>> res) {
		res.add(new ArrayList<>(ans));
		for (int i = start; i < nums.length; i++) {
			ans.add(nums[i]);
			dfs(i + 1, nums, ans, res);
			ans.remove(ans.size() - 1);
		}
	}
}
