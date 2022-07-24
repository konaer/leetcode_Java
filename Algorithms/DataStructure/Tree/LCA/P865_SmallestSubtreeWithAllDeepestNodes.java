package DataStructure.Tree.LCA;

import DataStructure.Tree.TreeNode;

public class P865_SmallestSubtreeWithAllDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair ans = dfs(root, 0);
        return ans.node;
    }
    
    private Pair dfs(TreeNode root, int depth) {
        if (root == null) {
            return new Pair(null, depth);
        }
        Pair left = dfs(root.left, depth + 1);
        Pair right = dfs(root.right, depth + 1);
        if (left.depth == right.depth) {
            return new Pair(root, left.depth);
        } else {
            return left.depth > right.depth ? left : right;
        }
    }
    
    class Pair {
        TreeNode node;
        int depth;
        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
