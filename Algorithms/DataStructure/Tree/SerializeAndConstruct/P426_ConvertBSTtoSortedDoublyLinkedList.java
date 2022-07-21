package DataStructure.Tree.SerializeAndConstruct;

public class P426_ConvertBSTtoSortedDoublyLinkedList {
    Node cur = null, head = null;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        cur.right = head;
        head.left = cur;
        return head;
    }
    
    private void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (cur == null) {
            head = node;
        } else {
            node.left = cur;
            cur.right = node;
        }
        cur = node;
        dfs(node.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};