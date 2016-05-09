package Google;

// the improve here is that after the swap, it would be in a descending
// order, so reverse it to make it ascending

//1.find the first index that a[i] < a[i + 1]  from right, noted as a[index]
//2. find the first num that larger than a[index] from right
//3. swap (index, the larger num)
//4. the right part from index+1 to end is now descending, reverse the order of that part to make it ascending
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		if (nums.length < 3) {
			swap(nums, 0, 1);
			return;
		}
		int index = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			for (int i = nums.length - 1; i > index; i--) {
				if (nums[i] > nums[index]) {
					swap(nums, i, index);
					break;
				}
			}
		}
		reverse(nums, index + 1, nums.length - 1);
	}

	private void reverse(int[] a, int start, int end) {
		while (start < end) {
			swap(a, start++, end--);
		}
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}