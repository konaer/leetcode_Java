package DataStructure.Tree.BST;

import DataStructure.Tree.TreeNode;

public class P450_DeleteInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = findSuccessor(root);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    
    private int findSuccessor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
