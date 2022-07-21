package DataStructure.Tree.BST;

import DataStructure.Tree.TreeNode;

public class P99_RecoverBST {
    TreeNode pre = null, m1 = null, m2 = null;
    
    public void recoverTree(TreeNode root) {
        dfs(root);
        swap(m1, m2);
    }
    
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre != null) {
            if (pre.val > node.val) {
                if (m1 == null) {
                    m1 = pre;
                }
                m2 = node;
            }
        }
        pre = node;
        dfs(node.right);
    }
    
    private void swap(TreeNode m1, TreeNode m2) {
        int temp = m1.val;
        m1.val = m2.val;
        m2.val = temp;
    }
}
