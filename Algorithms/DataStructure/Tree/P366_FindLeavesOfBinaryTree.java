package DataStructure.Tree;

import java.util.*;

public class P366_FindLeavesOfBinaryTree {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        findHeight(root);
        return ans;
    }
    
    private int findHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        int cur = Math.max(left, right) + 1;
        if (ans.size() == cur) {
            ans.add(new ArrayList<>());
        }
        ans.get(cur).add(root.val);
        return cur;
    }
}