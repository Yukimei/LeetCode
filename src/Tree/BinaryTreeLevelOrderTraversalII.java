package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				level.add(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			res.add(0, level);
		}
		return res;
	}
}
