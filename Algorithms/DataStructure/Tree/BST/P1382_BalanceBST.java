package DataStructure.Tree.BST;

import java.util.*;
import DataStructure.Tree.TreeNode;

public class P1382_BalanceBST {

    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        dfs(root);
        return balanceTree(0, list.size() - 1);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    private TreeNode balanceTree(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = balanceTree(l, mid - 1);
        root.right = balanceTree(mid + 1, r);
        return root;
    }
}
