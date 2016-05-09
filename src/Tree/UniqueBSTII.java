package Tree;

import java.util.ArrayList;
import java.util.List;
//key is that using a 2 layer for-loop to get all the root and left and right connected
// changing it to a smaller size question (because it return a list, so it can record all the posibilities)
public class UniqueBSTII {
	public List<TreeNode> generateTrees(int n) {
		if (n < 1) {
			return new ArrayList<TreeNode>();
		}
		return helper(1, n);
	}

	private List<TreeNode> helper(int start, int n) {
		List<TreeNode> res = new ArrayList<>();
		if (start > n) {
			res.add(null);
			return res;
		}
		for (int i = start; i <= n; i++) {
			List<TreeNode> left = helper(start, i - 1);
			List<TreeNode> right = helper(i + 1, n);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
}
