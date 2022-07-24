package DataStructure.Tree.LCA;

public class P1650_LCAofBST3 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node node1 = p, node2 = q;
        while (node1 != node2) {
            node1 = (node1 == null ? q : node1.parent);
            node2 = (node2 == null ? p : node2.parent);
        }
        return node1;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};