package Google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumProductOfWordLength {
	public int maxProduct(String[] words) {
		int[] fingerPrint = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			for (char c : words[i].toCharArray()) {
				fingerPrint[i] |= (1 << (c - 'a'));
			}
		}
		int max = 0;
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((fingerPrint[i] & fingerPrint[j]) == 0) {
					max = Math.max(words[i].length() * words[j].length(), max);
				}
			}
		}
		return max;
	}
}