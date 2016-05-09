package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//特别注意sort之后就不用找last index了因为会自动简直  target > sum的时候
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		
//		int lastIdx = binarySearch(candidates, target);
//		System.out.println("last idx = " + lastIdx); 
//		if (lastIdx == -1) {
//			return res;
//		}
		int lastIdx = candidates.length - 1;
		List<Integer> ans = new ArrayList<Integer>();
		dfs(candidates, 0, lastIdx, 0, target, ans, res);
		return res;
	}

	private void dfs(int[] num, int start, int end, int sum, int target, List<Integer> ans, List<List<Integer>> res) {
		if (sum == target) {
			res.add(new ArrayList<>(ans));
			return;
		} else if (sum > target) {
			return;
		}

		for (int i = start; i <= end; i++) {
			if (i > start && num[i] == num[i - 1]) {
				continue;
			}
			ans.add(num[i]);
			dfs(num, i, end, sum + num[i], target, ans, res);
			ans.remove(ans.size() - 1);
		}
	}

//	private int binarySearch(int[] num, int target) {
//		int start = 0, end = num.length - 1;
//		while (start + 1 < end) {
//			int mid = start + (end - start) / 2;
//			if (num[mid] == target) {
//				end = mid;
//			} else if (num[mid] > target) {
//				end = mid - 1;
//			} else {
//				start = mid + 1;
//			}
//		}
//		if (num[start] == target) {
//			return start;
//		} else if (num[end] == target) {
//			return end;
//		} else if (num[start] > target){
//			return -1;
//		} else {
//			return num.length -1;
//		}
//	}
	
	public static void main(String[] args) {
		CombinationSum c = new CombinationSum();
		int[] candidates = {1};
		int target = 2;
		c.combinationSum(candidates, target);
	}
}
