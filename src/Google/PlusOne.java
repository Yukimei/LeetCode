package Google;

public class PlusOne {
	public int[] plusOne(int[] digits) {
	    for (int i = digits.length - 1; i >= 0; i--) {
	        if (digits[i] == 9) {
	            digits[i] = 0;
	        } else {
	            digits[i]++;
	            break;
	        }
	    }
	    if (digits[0] != 0) {
	        return digits;
	    } else {
	        int[] res = new int[digits.length + 1];
	        res[0] = 1;
	        return res;
	    }
	}
}

