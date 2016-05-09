package Tree;
// key : 
// 1. goes to the very deep (so traverse first)
// 2. write return type so by call recursion can know the certain node's size, upper bound, lower bound
// (just as dp)
public class LargestBSTSubTree {
	private int max = 0;

	public int largestBSTSubtree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		traverse(root);
		return max;
	}

	private Result traverse(TreeNode root) {
		if (root == null) {
			return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		Result left = traverse(root.left);
		Result right = traverse(root.right);
		if (left.size == -1 || right.size == -1 || left.upper >= root.val || right.lower <= root.val) {
			return new Result(-1, 0, 0);
		}
		int size = left.size + right.size + 1;
		max = Math.max(size, max);
		return new Result(size, Math.min(root.val, left.lower), Math.max(root.val, right.upper));
	}

	class Result {
		int size;
		int lower;
		int upper;

		public Result(int s, int l, int u) {
			size = s;
			lower = l;
			upper = u;
		}
	}
}
