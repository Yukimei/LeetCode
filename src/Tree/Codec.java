package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "#";
		}
		StringBuilder sb = new StringBuilder();
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				sb.append("# ");
				continue;
			}
			sb.append(String.valueOf(cur.val)).append(" ");
			queue.offer(cur.left);
			queue.offer(cur.right);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals("#")) {
			return null;
		}
		String[] list = data.split(" ");
		int listIndex = 0;
		TreeNode root = new TreeNode(Integer.parseInt(list[listIndex++]));
		List<TreeNode> pre = new LinkedList<>();
		pre.add(root);

		Deque<String> queue = new LinkedList<>();
		queue.offer(list[listIndex++]);
		queue.offer(list[listIndex++]);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int preIdx = 0;
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.equals("#")) {
					preIdx++;
					continue;
				}

				TreeNode node = new TreeNode(Integer.parseInt(queue.poll()));
				if (preIdx % 2 == 0) {
					pre.get(preIdx / 2).left = node;
				} else {
					pre.get(preIdx / 2).right = node;
				}
				pre.add(node);
				queue.offer(list[listIndex++]);
				preIdx++;
			}
		}
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
