package DataStructure.Tree.BST;

import DataStructure.Tree.TreeNode;

public class P285_InorderSuccessorInBST {
    TreeNode pre = null, ans = null;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return ans;
    }
    
    private void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        dfs(root.left, p);
        if (pre == p) {
            ans = root;
        }
        pre = root;
        dfs(root.right, p);
    }
}
