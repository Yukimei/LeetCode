package Tree;

import java.util.LinkedList;
import java.util.List;

public class SumRootToLeafNumbers {
	private int sum = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		sumHelper(root, root.val);
		return sum;
	}

	private void sumHelper(TreeNode root, int res) {
		if (root.left == null && root.right == null) {
			sum += res;
			return;
		}

		if (root.left != null) {
			sumHelper(root.left, res * 10 + root.left.val);
		}
		if (root.right != null) {
			sumHelper(root.right, res * 10 + root.right.val);
		}
	}

	public static void main(String[] args) {
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		TreeNode root = new TreeNode(9);
		s.sumNumbers(root);
	}
}
