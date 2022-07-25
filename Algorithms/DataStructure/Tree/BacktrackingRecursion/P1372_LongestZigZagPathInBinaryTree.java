package DataStructure.Tree.BacktrackingRecursion;

import DataStructure.Tree.TreeNode;

public class P1372_LongestZigZagPathInBinaryTree {
    int ans = Integer.MIN_VALUE;
    
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans - 1;
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int zig = left[1] + 1;
        int zag = right[0] + 1;
        ans = Math.max(ans, Math.max(zig, zag));
        return new int[]{zig, zag};
    }
}
