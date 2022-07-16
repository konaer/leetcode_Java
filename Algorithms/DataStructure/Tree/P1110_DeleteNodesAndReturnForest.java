package DataStructure.Tree;

import java.util.*;

public class P1110_DeleteNodesAndReturnForest {
    
    private List<TreeNode> ans = new ArrayList<>();
    private Set<Integer> set = new HashSet<>();
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int val : to_delete) {
            set.add(val);
        }
        dfs(root, null);
        return ans;
    }
    
    private TreeNode dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (set.contains(root.val)) {
            root = null;
        } else {
            if (parent == null) {
                ans.add(root);
            }
        }
        TreeNode leftChild = dfs(left, root);
        TreeNode rightChild = dfs(right, root);
        if (root != null) {
            root.left = leftChild;
            root.right = rightChild;
        }
        return root;
    }
}

