package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
// serialize and deserialize a tree
// only two points. Both the serialize and deserilize keep the same traverse order
// this example use inorder and (divide and conquer)
// remember to handle " null" value. so it can be serilize and deserialize
public class Codec2 {
	private final String SPLITTER = ",";
	private final String NULL = "#";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(NULL).append(SPLITTER);
			return;
		}
		sb.append(root.val).append(SPLITTER);
		buildString(root.left, sb);
		buildString(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		List<String> list = new LinkedList<String>();
		list.addAll(Arrays.asList(data.split(SPLITTER)));
		return buildTree(list);
	}

	private TreeNode buildTree(List<String> list) {
		String cur = list.remove(0);
		if (cur.equals(NULL)) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(cur));
		root.left = buildTree(list);
		root.right = buildTree(list);
		return root;
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}
