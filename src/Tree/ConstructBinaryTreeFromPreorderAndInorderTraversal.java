package Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	// key is let the recursion select the successive root
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0
				|| preorder.length != inorder.length) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(preorder, inorder, 0, inorder.length - 1, 0, map);
	}

	private TreeNode helper(int[] pre, int[] in, int inl, int inr, int prel, Map<Integer, Integer> map) {
		if (inl > inr) {
			return null;
		}
		int mid = map.get(pre[prel]);
		TreeNode root = new TreeNode(in[mid]);
		TreeNode left = helper(pre, in, inl, mid - 1, prel + 1, map);
		TreeNode right = helper(pre, in, mid + 1, inr, prel + (mid - inl) + 1, map);
		root.left = left;
		root.right = right;
		return root;
	}
}
