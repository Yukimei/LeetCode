package Tree;

public class InorderSuccessorInBST {
	private TreeNode pre = null;
	private boolean flag;

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}
		TreeNode left = inorderSuccessor(root.left, p);
		if (root == p && pre == null) {
			pre = root;
		} else if (pre != null && !flag) {
			flag = true;
			return root;
		}
		TreeNode right = inorderSuccessor(root.right, p);
		return left != null ? left : right;
	}
}
