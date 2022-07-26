package DataStructure.Tree.BacktrackingRecursion;

import DataStructure.Tree.TreeNode;

public class P543_DiameterOfBinaryTree {
    int ans = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; 
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }
}
