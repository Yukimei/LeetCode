package Google;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
// Key is to use inorder (use a stack to store itself and all the left child)
// this actually imitate the inorder recursion
// the stack is the call stack currently
public class BSTIterator {
	Deque<TreeNode> stack;

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
		TreeNode next = stack.pollFirst();
		pushAll(next.right);
		return next.val;
	}

	private void pushAll(TreeNode root) {
		while (root != null) {
			stack.offerFirst(root);
			root = root.left;
		}
	}
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */