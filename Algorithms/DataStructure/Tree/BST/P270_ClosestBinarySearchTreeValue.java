package DataStructure.Tree.BST;

import DataStructure.Tree.TreeNode;

public class P270_ClosestBinarySearchTreeValue {
    double min = Double.MAX_VALUE;
    int ans = 0;
    
    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return ans;
    }
    
    private void dfs(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (Math.abs(root.val - target) < min) {
            min = Math.abs(root.val - target);
            ans = root.val;
        }
        if (root.val > target) {
            dfs(root.left, target);
        } else if (root.val < target) {
            dfs(root.right, target);
        } else {
            return;
        }
    }
}
