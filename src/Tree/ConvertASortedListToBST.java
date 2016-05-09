package Tree;

//key is to do binary partition recursion (divide and conquer)
public class ConvertASortedListToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length < 1) {
			return null;
		}
		return helper(nums, 0, nums.length - 1);
	}

	private TreeNode helper(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, start, mid - 1);
		root.right = helper(nums, mid + 1, end);
		return root;
	}
}
