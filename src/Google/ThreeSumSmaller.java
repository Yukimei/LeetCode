package Google;

import java.util.Arrays;

// the key is that 
// 1. sort first
// 2. count += k - j; 
public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				if (nums[j] + nums[k] + nums[i] < target) {
					count += k - j; // this is the key!!
					j++;
				} else {
					k--;
				}
			}
		}
		return count;
	}
}