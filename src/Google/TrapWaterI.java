package Google;

public class TrapWaterI {
	public int trap(int[] height) {
		if (height == null || height.length < 3) {
			return 0;
		}
		int left = 0, right = height.length - 1;
		int sum = 0;
		int leftHeight = height[left], rightHeight = height[right];
		while (left < right) {
			if (leftHeight <= rightHeight) {
				sum += Math.max(0, leftHeight - height[++left]);
				leftHeight = Math.max(leftHeight, height[left]);
			} else {
				sum += Math.max(0, rightHeight - height[--right]);
				rightHeight = Math.max(rightHeight, height[right]);
			}
		}
		return sum;
	}
}
