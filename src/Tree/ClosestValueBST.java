package Tree;
// use global result to record to closest!
public class ClosestValueBST {
	public int closestValue(TreeNode root, double target) {
		if (root == null) {
			return -1;
		}
		int res = root.val;
		while (root != null) {
			res = Math.abs(target - res) < Math.abs(target - root.val) ? res : root.val;
			if (root.val == target) {
				return root.val;
			} else if (root.val < target) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return res;
	}
}
