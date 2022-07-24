package DataStructure.Tree.LCA;

import java.util.*;
import DataStructure.Tree.TreeNode;

public class P1676_LCAofBST4 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node);
        }
        return dfs(root, set);
    }
    
    private TreeNode dfs(TreeNode root, Set<TreeNode> set) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left, set);
        TreeNode right = dfs(root.right, set);
        if (set.contains(root)) {
            return root;
        }
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }   
    }
}
