package DataStructure.Tree.Traversal;

import java.util.*;

public class P144_BinaryTreePreorderTraversal {
    //iteration
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                ans.add(node.val);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return ans;
    }

    //recrusion
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val) {
        this.val = val;
    }
}