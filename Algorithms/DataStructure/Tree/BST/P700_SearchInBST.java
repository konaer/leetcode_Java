package DataStructure.Tree.BST;

import DataStructure.Tree.TreeNode;

public class P700_SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
            return null;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }
}
