package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
// greedy is better here because it ustilize the characteristics of a BST
// and can stop earlier

// method 1: greedy, set leftmost is the worst, each time compare the rightmost with
// the left most, if the rightmost is better, than remove the head of list
// when rightmost can't be better, stop recursion earlier
public class ClosestBSTValues {
    // method 1: greedy, set leftmost is the worst, each time compare the rightmost with
    // the left most, if the rightmost is better, than remove the head of list
    // when rightmost can't be better, stop recursion earlier
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new LinkedList<>();
		helper(res, root, target, k);
		return res;
	}

	private void helper(List<Integer> res, TreeNode root, double target, int k) {
		if (root == null) {
			return;
		}
		helper(res, root.left, target, k);
		if (res.size() < k) {
			res.add(root.val);
		} else {
			if (Math.abs(root.val - target) < Math.abs(res.get(0) - target)) {
				res.remove(0);
				res.add(root.val);
			} else {
				return;
			}
		}
		helper(res, root.right, target, k);
	}
	
	// method 2, use pre and successor stacks
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> pre = new LinkedList<>();
        Deque<TreeNode> succ = new LinkedList<>();
        
        TreeNode cur = root;
        //search the closest
        while (cur != null) {
             if (cur.val <= target) {
                pre.offerFirst(cur);
                cur = cur.right;
            } else {
                succ.offerFirst(cur);
                cur = cur.left;
            }
        }
        while (k > 0) {
            if (pre.isEmpty() && succ.isEmpty()) {
                break;
            } else if (pre.isEmpty()) {
                res.add(getSucc(succ));
            } else if (succ.isEmpty()) {
                res.add(getPre(pre));
            } else if (Math.abs(pre.peekFirst().val - target) < Math.abs(succ.peekFirst().val - target)) {
                res.add(getPre(pre));
            } else {
                res.add(getSucc(succ));
            }
            k--;
        }
        return res;
    }
    private int getPre(Deque<TreeNode> pre) {
        TreeNode cur = pre.pollFirst();
        TreeNode next = cur.left;
        while (next != null) {
            pre.offerFirst(next);
            next = next.right;
        }
        return cur.val;
    }
    private int getSucc(Deque<TreeNode> succ) {
        TreeNode cur = succ.pollFirst();
        TreeNode next = cur.right;
        while (next != null) {
            succ.offerFirst(next);
            next = next.left;
        }
        return cur.val;
    }

}
