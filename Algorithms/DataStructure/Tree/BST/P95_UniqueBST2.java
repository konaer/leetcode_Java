package DataStructure.Tree.BST;

import java.util.*;
import DataStructure.Tree.TreeNode;

public class P95_UniqueBST2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return dfs(1, n);
    }
    
    private List<TreeNode> dfs(int l, int r) {
        List<TreeNode> ans = new ArrayList<>();
        if (l > r) {
            ans.add(null);
            return ans;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> lefts = dfs(l, i - 1);
            List<TreeNode> rights = dfs(i + 1, r);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
