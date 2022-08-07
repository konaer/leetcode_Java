package DataStructure.Tree.BST;

import DataStructure.Tree.TreeNode;

public class P530_MinimumAbsoluteDifferenceInBST {
    private int ans = Integer.MAX_VALUE;
    private int pre = -1;
    
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, Math.abs(pre - root.val));
        } 
        pre = root.val;
        dfs(root.right);
    }
}
