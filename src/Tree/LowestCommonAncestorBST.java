package Tree;

public class LowestCommonAncestorBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		int min = Math.min(p.val, q.val);
		int max = Math.max(p.val, q.val);
		while (root != null) {
			if (root.val >= min && root.val <= max) {
				return root;
			} else if (root.val > min) {
				root = root.left;
			} else if (root.val < max) {
				root = root.right;
			}
		}
		return null;
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
			return root;
		} else if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}
	}

}
