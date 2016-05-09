package Tree;

import java.util.HashMap;
import java.util.Map;

//key is let the recursion select the successive root
public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0
				|| inorder.length != postorder.length) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1, map);
	}

	private TreeNode helper(int[] in, int[] post, int inl, int inr, int postr, Map<Integer, Integer> map) {
		if (inl > inr) {
			return null;
		}
		int mid = map.get(post[postr]);
		TreeNode root = new TreeNode(in[mid]);
		root.right = helper(in, post, mid + 1, inr, postr - 1, map);
		root.left = helper(in, post, inl, mid - 1, postr - (inr - mid + 1), map);
		return root;
	}
}
