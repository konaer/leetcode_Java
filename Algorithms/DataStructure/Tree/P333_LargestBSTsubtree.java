package DataStructure.Tree;

public class P333_LargestBSTsubtree {
    //o(n) 每一个iteration一遍
    public int largestBSTSubtree(TreeNode root) {
        return dfs(root).size;
    }

    private Node dfs(TreeNode root) {
        if (root == null) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Node left = dfs(root.left);
        Node right = dfs(root.right);
        if (root.val > left.max && root.val < right.min) {
            int min = Math.min(left.min, root.val);
            int max = Math.max(right.max, root.val);
            return new Node(min, max, left.size + right.size + 1);
        } else {
            return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
        }
    }

    class Node {
        int min, max, size;

        public Node() {
        }

        public Node(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
}