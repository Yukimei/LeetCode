package Tree;

// the key for inorder here is that 
// 1. set first, second, pre and know its definition
// 2. first is the element that larger than its follower
// 3. second is the element that smaller than its predecessor
// 4. know when to handle first and second
// 5. remember to innit pre(set a dummy value as MIN_VALUE)
// 6. know when to replace pre;
public class RecoverBST {
	private TreeNode first, second;
	private TreeNode pre;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		pre = new TreeNode(Integer.MIN_VALUE);
		inorder(root);
		swap(first, second);
	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);

		if (first == null && pre.val >= root.val) {
			first = pre;
		}
		if (first != null && pre.val >= root.val) {
			second = root;
		}
		pre = root;

		inorder(root.right);
	}

	private void swap(TreeNode a, TreeNode b) {
		int tmp = a.val;
		a.val = b.val;
		b.val = tmp;
	}

	// moris traversal
	public void recoverTree2(TreeNode root) {
		TreeNode first = null, second = null, pre = null;
		while (root != null) {
			if (root.left != null) {
				TreeNode tmp = root.left;
				while (tmp.right != null && tmp.right != root) {
					tmp = tmp.right;
				}
				if (tmp.right == null) {
					// build thread;
					tmp.right = root;
					root = root.left;
				} else {
					if (pre != null && pre.val > root.val) {
						if (first == null) {
							first = pre;
						}
						second = root;
					}
					pre = root;
					root = root.right;
					// clear thread
					tmp.right = null;
				}
			} else {
				if (pre != null && pre.val > root.val) {
					if (first == null) {
						first = pre;
					}
					second = root;
				}
				pre = root;
				root = root.right;
			}
		}
		// swap
		if (first != null && second != null) {
			int t = first.val;
			first.val = second.val;
			second.val = t;
		}
	}
}
