package DataStructure.Tree.Traversal;

import java.util.*;
import DataStructure.Tree.TreeNode;

public class P145_BinaryPostorderTraversal {
    //o(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root, pre = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == pre) {
                ans.add(node.val);
                pre = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return ans;
    }
}
