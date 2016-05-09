package Tree;
// 1. use height function to get the actual height - 1 (easy to calculate the nodes num)
// 2. judge whether right subtree height == height of root - 1;
// if so, left subtree is complete, total nodes num + root = 2 ^ (height of left subtree) + 1
// which is 2 ^ h
// else, right subtree is complete with a level less, total nodes num = 2 ^ (height of right subtree) + 1,
// which is 2 ^ (h - 1)
public class CountCompleteTreeNodes {
	private int height(TreeNode root) { // the height result is actual height -
										// 1;
		return root == null ? -1 : height(root.left) + 1;
	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int nodes = 0, h = height(root);
		while (root != null) {
			if (height(root.right) == h - 1) { // calculate the height of right.
												// if it equals to h -1, means
												// left is complete tree with
												// height (h); nodes number
												// (plus root) = 2 ^ h
				nodes += 1 << h; // bit manipulation is faster than pow
				root = root.right;
			} else { // if not equals to h - 1, means right is complete tree
						// with height (h - 1), nodes number (plus root) == 2 ^
						// (h - 1)
				nodes += 1 << (h - 1);
				root = root.left;
			}
		}
		return nodes;
	}
	// this is recursion
	class Solution {
	    int height(TreeNode root) {
	        return root == null ? -1 : 1 + height(root.left);
	    }
	    public int countNodes(TreeNode root) {
	        int h = height(root);
	        return h < 0 ? 0 :
	               height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
	                                         : (1 << h-1) + countNodes(root.left);
	    }
	}
	
}
