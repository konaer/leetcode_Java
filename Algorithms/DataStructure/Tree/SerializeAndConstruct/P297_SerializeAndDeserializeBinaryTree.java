package DataStructure.Tree.SerializeAndConstruct;
import java.util.*;

import DataStructure.Tree.TreeNode;

public class P297_SerializeAndDeserializeBinaryTree {
    
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",").append(serialize(root.left))
            .append(",").append(serialize(root.right));
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String node = queue.poll();
        if (node.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}
