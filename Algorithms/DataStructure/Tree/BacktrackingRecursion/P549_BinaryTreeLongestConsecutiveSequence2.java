package DataStructure.Tree.BacktrackingRecursion;

import DataStructure.Tree.TreeNode;

public class P549_BinaryTreeLongestConsecutiveSequence2 {
    
    int res = Integer.MIN_VALUE;
    
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] ans = {1, 1};
        if (node.left != null) {
            int[] left = dfs(node.left);
            if (node.val - node.left.val == 1) {
                ans[0] = left[0] + 1;
            }else if (node.left.val - node.val == 1) {
                ans[1] = left[1] + 1;
            }
        }
        if (node.right != null) {
            int[] right = dfs(node.right);
            if (node.val - node.right.val == 1) {
                ans[0] = Math.max(ans[0], right[0] + 1);
            }else if (node.right.val - node.val == 1) {
                ans[1] = Math.max(ans[1], right[1] + 1);
            }
        }
        res = Math.max(res, ans[0] + ans[1] - 1);
        return ans;
    }
}
