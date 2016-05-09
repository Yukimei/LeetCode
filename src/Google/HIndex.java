package Google;

//1. ++ determins that the sum of count
// can not be larger than
// citations.length, maximally ++ for
// citations.length times

//2. h >= i means that the num before i cannot be larger
// than i (constraint to the sum)
public class HIndex {

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		int[] count = new int[citations.length + 1];
		for (int c : citations) {
			if (c > citations.length) { // ++ determins that the sum of count
										// can not be larger than
										// citations.length, maximally ++ for
										// citations.length times
				count[citations.length]++;
			} else {
				count[c]++;
			}
		}

		int h = 0;
		for (int i = citations.length; i >= 0; i--) {
			h += count[i];
			if (h >= i) { // this means that the num before i cannot be larger
							// than i (constraint to the sum)
				return i;
			}
		}
		return 0;
	}
}