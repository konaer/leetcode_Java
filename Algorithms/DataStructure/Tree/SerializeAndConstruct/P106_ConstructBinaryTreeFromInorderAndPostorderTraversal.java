package DataStructure.Tree.SerializeAndConstruct;

import java.util.HashMap;
import java.util.Map;

import DataStructure.Tree.TreeNode;

public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length- 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(postorder, 0, postorder.length - 1);
    }
    
    private TreeNode dfs(int[] pos, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(pos[index--]);
        int i = map.get(root.val);
        root.right = dfs(pos, i + 1, r);
        root.left= dfs(pos, l, i - 1);
        return root;
    }
}
