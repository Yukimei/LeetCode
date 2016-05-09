package Google;

//key is to use binary deduct
public class MedianOfTwoSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length + nums2.length;
		if (n % 2 == 0) {
			return (binaryDeduct(n / 2, nums1, 0, nums2, 0) + binaryDeduct(n / 2 + 1, nums1, 0, nums2, 0)) / 2.0;
		} else {
			return binaryDeduct(n / 2 + 1, nums1, 0, nums2, 0);
		}
	}

	private int binaryDeduct(int k, int[] a, int i, int[] b, int j) {
		if (k == 1) {
			if (i >= a.length) {
				return b[j];
			} else if (j >= b.length) {
				return a[i];
			} else {
				return Math.min(a[i], b[j]);
			}
		}
		int anum = i + k / 2 - 1 >= a.length ? Integer.MAX_VALUE : a[i + k / 2 - 1];
		int bnum = j + k / 2 - 1 >= b.length ? Integer.MAX_VALUE : b[j + k / 2 - 1];
		if (anum >= bnum) {
			return binaryDeduct(k - k / 2, a, i, b, j + k / 2);
		} else {
			return binaryDeduct(k - k / 2, a, i + k / 2, b, j);
		}
	}
}