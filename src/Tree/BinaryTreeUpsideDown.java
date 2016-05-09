package Tree;

public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode newRoot = upsideDownBinaryTree(root.left);
		root.left.left = root.right;
		root.right = null;
		root.left.right = root;
		root.left = null;

		return newRoot;
	}
}
