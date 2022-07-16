package DataStructure.Tree.Traversal;

import java.util.*;
import DataStructure.Tree.TreeNode;

public class P94_BinaryTreeInorderTraversal {
    //o(n)
    //iteration
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>(); 
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ans.add(node.val);
            node = node.right;
        }
        return ans;
    }


    //recursion
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> inorderTraversal2(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}
