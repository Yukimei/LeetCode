package Google;

import java.util.HashMap;
import java.util.Map;

//key is to use two pointers, the end move one per time, the start move until the frame has only two distinct characters
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0;
		int max = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
			end++;
			while (map.size() > 2) {
				char cs = s.charAt(start);
				map.put(cs, map.get(cs) - 1);
				if (map.get(cs) == 0) {
					map.remove(cs);
				}
				start++;
			}
			max = Math.max(end - start, max);
		}
		return max;
	}
}