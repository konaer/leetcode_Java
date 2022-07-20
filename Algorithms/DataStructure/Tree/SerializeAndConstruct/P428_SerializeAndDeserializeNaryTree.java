package DataStructure.Tree.SerializeAndConstruct;

import java.util.*;

public class P428_SerializeAndDeserializeNaryTree {
    
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> list = new ArrayList<>();
        dfs(root, list);
        return String.join(",", list);
    }

    private void dfs(Node root, List<String> list) {
        if (root == null) {
            return;
        }
        list.add(String.valueOf(root.val));
        list.add(String.valueOf(root.children.size()));
        for (Node child : root.children) {
            dfs(child, list);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return dfs2(queue);
    }

    private Node dfs2(Queue<String> queue) {
        String node = queue.poll();
        Node root = new Node(Integer.parseInt(node), new ArrayList<>());
        int size = Integer.parseInt(queue.poll());
        for (int i = 0; i < size; i++) {
            root.children.add(dfs2(queue));
        }
        return root;
    }
}

class Node {
    public int val;
    public List<Node> children;
    
    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
