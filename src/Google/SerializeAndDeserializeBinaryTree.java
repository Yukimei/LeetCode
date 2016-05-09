package Google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTree {
    private static final String SPLITTER = ",";
    private static final String NULL = "X";
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
        List<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(data.split(SPLITTER)));
        return buildTree(list);
    }
    
    private TreeNode buildTree(List<String> list) {
        String val = list.remove(0);
        if (val.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = buildTree(list);
        root.right = buildTree(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
