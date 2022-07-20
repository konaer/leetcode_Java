package DataStructure.Tree.SerializeAndConstruct;

import java.util.*;

import DataStructure.Tree.TreeNode;

public class P105_ConstructBinaryTreePreorderAndInorderTraversal {
    
    int index = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] pre, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(pre[index++]);
        int i = map.get(root.val);
        root.left = dfs(pre, l, i - 1);
        root.right = dfs(pre, i + 1, r);
        return root;
    }
}
