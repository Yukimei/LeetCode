package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	private int maxDepth = 0;

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		dfs(root, res, 0);
		return res;
	}

	private void dfs(TreeNode root, List<Integer> res, int depth) {
		if (root == null) {
			return;
		}
		if (depth == maxDepth) {
			res.add(root.val);
			maxDepth++;
		}
		dfs(root.right, res, depth + 1);
		dfs(root.left, res, depth + 1);
	}
}
