package PopularTopic.Array.TopK;


import java.util.*;
import DataStructure.Tree.TreeNode;

public class P230_KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            node = node.right;
        }
        return -1;
    }
}
