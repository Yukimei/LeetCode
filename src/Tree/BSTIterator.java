package Tree;

import java.util.Deque;
import java.util.LinkedList;
//time : O(1) avg,  space O(h)   h is height of the BST
// The key here is every time call next function, push all the left most into the stack
// (stack stores the leftmost  , which is the smallest nodes)
//
public class BSTIterator {
    private Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pollFirst();
        pushAll(cur.right);
        return cur.val;
    }
    
    private void pushAll(TreeNode root) {
        while(root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */