package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryPostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			res.add(0, cur.val);
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			}
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			}
		}
		return res;
	}
}
