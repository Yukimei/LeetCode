package Google;

public class BinaryTreeLongestConsecutiveSequence {
    private int max = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root.left, root.val, 1);
        helper(root.right, root.val, 1);
        return max;
    }
    private void helper(TreeNode root, int prev, int count) {
        if (root == null) {
            return;
        }
        if (root.val == prev + 1) {
            count++;
            max = count > max ? count : max;
        } else {
            count = 1;
        }
        helper(root.left, root.val, count);
        helper(root.right, root.val, count);
    }
}