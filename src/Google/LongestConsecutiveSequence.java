package Google;

import java.util.HashMap;
import java.util.Map;

//key is that the left part must connect to the smallest, right part must connect to the largest
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int n : nums) {
			if (!map.containsKey(n)) {
				int leftmost = n, rightmost = n;
				map.put(n, n);
				if (map.containsKey(n - 1)) {
					leftmost = map.get(n - 1);
					map.put(n, leftmost);
					map.put(leftmost, n);
				}
				if (map.containsKey(n + 1)) {
					rightmost = map.get(n + 1);
					map.put(rightmost, leftmost);
					map.put(leftmost, rightmost);
				}
				max = Math.max(rightmost - leftmost + 1, max);
			}
		}
		return max;
	}
}