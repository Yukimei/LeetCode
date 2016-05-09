package Google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//1. the key is that the innit of count of each node is 1 (itself)
// node.count is the number smaller than itself + itself
// 2. notice that the count for each node is use
// to know if the val > than that node, how
// many node is smaller than it. therefore
// the = relation should still in the left
// subtree(because if there is val >
// root.val, that val also > this val)
//3. the original count is set to be 1 (itself ) at the begining
public class CountOfSmallerNumberAfterItself {
	// the key is that the innit of count of each node is 1 (itself)
	// node.count is the number smaller than itself + itself
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		res.add(0);
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		for (int i = nums.length - 2; i >= 0; i--) {
			int count = insertNode(root, nums[i]);
			res.add(count);
		}
		Collections.reverse(res);
		return res;
	}

	private int insertNode(TreeNode root, int val) {
		int thisCount = 0;
		while (true) {
			if (root.val >= val) { // notice that the count for each node is use
									// to know if the val > than that node, how
									// many node is smaller than it. therefore
									// the = relation should still in the left
									// subtree(because if there is val >
									// root.val, that val also > this val)
				root.count++;
				if (root.left == null) {
					root.left = new TreeNode(val);
					break;
				} else {
					root = root.left;
				}
			} else {
				thisCount += root.count;
				if (root.right == null) {
					root.right = new TreeNode(val);
					break;
				} else {
					root = root.right;
				}
			}
		}
		return thisCount;
	}

	class TreeNode {
		int val;
		int count = 1;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

	}
}
