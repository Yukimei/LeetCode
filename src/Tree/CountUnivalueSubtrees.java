package Tree;
// notice that the different subtree is defined by different root node!!!
// so just do the count at root will be ok (left.val = right.val = root.val)

public class CountUnivalueSubtrees {
	private int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		helper(root);
		return count;
	}

	private boolean helper(TreeNode root) {
		if (root == null) {
			return true;
		}

		boolean left = helper(root.left);
		boolean right = helper(root.right);

		if (left && right) {
			if (root.left != null && root.left.val != root.val) {
				return false;
			}
			if (root.right != null && root.right.val != root.val) {
				return false;
			}
			count++;
			return true;
		}
		return false;
	}
}
