package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
// key is the recursion stack condition 
// 1. root is not null (so it can recurse to deep level)
// 2. stack is not null 
// and know when to push right node to the recursion stack
public class BinaryTreeInorderTraversalII {
    public List<Integer> inorderTraversaII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while ( cur != null || !stack.isEmpty()) { // the two conditions of the recursion stack
            while (cur != null) { // there can be nodes put into the recursion stack
                stack.offerFirst(cur);
                cur = cur.left;
            }
            // cur becomes null now, trace back to recursion stack
            cur = stack.pollFirst();
            res.add(cur.val);
            cur = cur.right;  // do recursion for right now
        }
        return res;
    }
}
