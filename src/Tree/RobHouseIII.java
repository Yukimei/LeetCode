package Tree;

import java.util.HashMap;

// key is use recursion to do DP
// either current  + two level down   OR   next level
// use map to reduce repetive calculatio
public class RobHouseIII {
    private HashMap<TreeNode, Integer> store = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) {
          return 0;  
        }
        if (store.containsKey(root)) {
            return store.get(root);
        }
        int temp = root.val;
        if (root.left != null) {
            temp += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            temp += rob(root.right.left) + rob(root.right.right);
        }
        int res = Math.max(temp, rob(root.left) + rob(root.right));
        store.put(root, res);
        return res;
    }
}
