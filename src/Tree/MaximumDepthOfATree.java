package Tree;

public class MaximumDepthOfATree {
	private int max = Integer.MIN_VALUE;

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		getDepth(root, 1);
		return max;
	}

	private void getDepth(TreeNode root, int depth) {
		if (root.left == null && root.right == null) {
			max = depth > max ? depth : max;
		}
		if (root.left != null) {
			getDepth(root.left, depth + 1);
		}
		if (root.right != null) {
			getDepth(root.right, depth + 1);
		}
	}
}
