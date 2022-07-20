package DataStructure.Tree.SerializeAndConstruct;

import java.util.*;
import DataStructure.Tree.TreeNode;

public class P889_ConstructBinaryTreePreorderPostorderTraversal {

    int index = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1);

    }

    private TreeNode dfs(int[] pre, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(pre[index++]);
        if (l == r || index == pre.length) {
            return root;
        }
        int i = map.get(pre[index]);
        root.left = dfs(pre, l, i);
        root.right = dfs(pre, i + 1, r - 1);
        return root;
    }
}
