package Tree;

public class PathSumI {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return dfs(root, root.val, sum);
	}

	private boolean dfs(TreeNode root, int sum, int target) {
		if (root.left == null && root.right == null) {
			return sum == target;
		}
		boolean left = false;
		if (root.left != null) {
			left = dfs(root.left, sum + root.left.val, target);
		}
		boolean right = false;
		if (root.right != null) {
			right = dfs(root.right, sum + root.right.val, target);
		}
		return left || right;
	}
}
