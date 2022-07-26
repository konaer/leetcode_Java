package DataStructure.Tree;

public class P101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }
    
    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean l = dfs(p.left, q.right);
        boolean r = dfs(p.right, q.left);
        return l && r;
    }
}
