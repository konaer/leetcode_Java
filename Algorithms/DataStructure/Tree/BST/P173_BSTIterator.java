package DataStructure.Tree.BST;

import java.util.*;
import DataStructure.Tree.TreeNode;

public class P173_BSTIterator {
    List<Integer> list;
    int index;
    
    public P173_BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        dfs(root);
    }
    
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index < list.size();
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
