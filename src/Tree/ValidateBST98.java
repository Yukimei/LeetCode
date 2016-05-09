package Tree;

import java.util.Stack;

public class ValidateBST98 {
	public boolean isValidBST(TreeNode root) {
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean helper(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val < min || root.val > max) {
			return false;
		} else {
			return helper(root.left, min, root.val) && helper(root.right, root.val, max);
		}
	}

	public boolean isValidBST2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode pre = null;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode p = stack.pop();
				if (pre != null && p.val <= pre.val) {
					return false;
				}
				pre = p;
				cur = p.right;
			}
		}
		return true;
	}
}
