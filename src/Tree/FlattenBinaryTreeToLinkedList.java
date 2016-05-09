package Tree;
// key is to see how the nodes are linked
// the left always become the right;
// the right always linked to the right most of left subtree;
// loop the process
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    // the recursion can work here because it always handles leftmost then handle right
    // so always get right connected to the left's rightmost  BEFORE it gets flattened.
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        root.left = null;
        
        TreeNode cur = root;
        while (cur != null) {
            cur = cur.right;
        }
        cur.right = right;
        
    }
}
