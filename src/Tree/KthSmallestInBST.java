package Tree;

public class KthSmallestInBST {
	private int count = 0;
	private int ans = -1;

	public int kthSmallest(TreeNode root, int k) {
		inorder(root, k);
		return ans;
	}

	private void inorder(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		
		inorder(root.left, k);

		count++;
		if (count == k) {
			ans = root.val;
			return;
		}
		
		inorder(root.right, k);

	}
}
