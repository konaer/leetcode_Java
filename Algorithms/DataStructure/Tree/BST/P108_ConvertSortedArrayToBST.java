package DataStructure.Tree.BST;

import DataStructure.Tree.TreeNode;

public class P108_ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    
    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l, mid - 1);
        root.right = dfs(nums, mid + 1, r);
        return root;
    }
}
