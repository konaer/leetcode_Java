package DataStructure.Tree.BacktrackingRecursion;

import DataStructure.Tree.TreeNode;

public class P124_BinaryTreeMaximumPathSum {
    //时间n
	//空间最差是n
    int ans = Integer.MIN_VALUE;    
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        int path = left + right + node.val;
        ans = Math.max(path, ans);
        return Math.max(left, right) + node.val;
    }
}
