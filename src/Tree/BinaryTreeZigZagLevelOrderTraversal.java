package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// key is that the level list is order -> add     is reverse order -> add(0, )
public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean order = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (order) {
                    level.add(cur.val);
                } else {
                    level.add(0, cur.val);
                }
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            order = !order;
            res.add(level);
        }
        return res;
    }
}
