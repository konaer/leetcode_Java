package DataStructure.Tree.SerializeAndConstruct;

import java.util.*;
import DataStructure.Tree.TreeNode;

public class P449_SerializeAndDeserializeBST {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list);
        return String.join(",", list);
    }

    private void dfs(TreeNode root, List<String> list) {
        if (root == null) {
            return;
        }    
        list.add(String.valueOf(root.val));
        dfs(root.left, list);
        dfs(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs2(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs2(Queue<String> queue, int low, int high) {
        if (queue.isEmpty()) {
            return null;
        }
        int val = Integer.parseInt(queue.peek());
        if (val < low || val > high) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
        root.left = dfs2(queue, low, root.val);
        root.right = dfs2(queue, root.val, high);
        return root;
    }

}
