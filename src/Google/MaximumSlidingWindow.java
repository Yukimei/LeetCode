package Google;

import java.util.Deque;
import java.util.LinkedList;

//step:
//1.use monotonic stack
//2. decide whether remove the last (because it cannot keep monotonic) (the prev largest < current largest)
//3. add current index
//4. decide whether the first element is out of window, remove first
//5. add first to the window maximum result
public class MaximumSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1) {
			return new int[0];
		}
		if (k == 1) {
			return nums;
		}
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> mono = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			while (!mono.isEmpty() && nums[i] >= nums[mono.getLast()]) {
				mono.removeLast();
			}
			mono.add(i);
			if (mono.getFirst() < i - k + 1) {
				mono.removeFirst();
			}
			if (i >= k - 1) {
				res[i - k + 1] = nums[mono.getFirst()];
			}

		}
		return res;
	}
}