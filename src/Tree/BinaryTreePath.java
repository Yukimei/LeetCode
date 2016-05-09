package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		String s = "";
		dfs(root, res, s + root.val);
		return res;
	}

	private void dfs(TreeNode root, List<String> res, String s) {
		if (root.left == null && root.right == null) {
			res.add(s);
			return;
		}
		if (root.left != null) {
			dfs(root.left, res, s + "->" + root.left.val);
		}
		if (root.right != null) {
			dfs(root.right, res, s + "->" + root.right.val);
		}
	}
}
