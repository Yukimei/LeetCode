package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        } 
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, sum, new ArrayList<Integer>(), res);
        return res;
    }
    private void dfs(TreeNode root, int sum, int target, List<Integer> list, List<List<Integer>> res) {
        if (root.left == null && root.right == null && sum + root.val == target) {
            list.add(root.val);
            res.add(new ArrayList(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            dfs(root.left, sum + root.val, target, list, res);
        }
        if (root.right != null) {
            dfs(root.right, sum + root.val, target, list, res);
        }
        list.remove(list.size() - 1);
    }
}
