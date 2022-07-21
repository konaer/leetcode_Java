package DataStructure.Tree.BST;

import DataStructure.Tree.TreeNode;

public class P98_ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= high) {
            return false;
        }
        boolean left = dfs(root.left, low, root.val);
        boolean right = dfs(root.right, root.val, high);
        return left && right;
    }
}
