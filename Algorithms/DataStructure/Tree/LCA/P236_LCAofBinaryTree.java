package DataStructure.Tree.LCA;

import DataStructure.Tree.TreeNode;

public class P236_LCAofBinaryTree {
    //o(n) because the tree may not balanced.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (root == p || root == q) {
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
