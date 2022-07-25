package DataStructure.Tree.BacktrackingRecursion;

import DataStructure.Tree.TreeNode;

public class P1120_MaximumAverageSubtree {
    //时间o(n)自底向上，遍历一次
	//空间n，最好情况logn
    double ans = Double.MIN_VALUE;
    
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int sum = left[0] + right[0] + node.val;
        int num = left[1] + right[1] + 1;
        ans = Math.max(ans, (double)sum / num);
        return new int[]{sum, num};
    }
}
