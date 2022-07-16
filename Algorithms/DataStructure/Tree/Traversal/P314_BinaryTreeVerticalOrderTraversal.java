package DataStructure.Tree.Traversal;

import java.util.*;
import DataStructure.Tree.TreeNode;

public class P314_BinaryTreeVerticalOrderTraversal {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<TreeNode, Integer> positions = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        positions.put(root, 0);
        int minKey = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int index = positions.get(node);
            map.computeIfAbsent(index, k -> new ArrayList<>()).add(node.val);
            minKey = Math.min(minKey, index);
            if (node.left != null) {
                queue.offer(node.left);
                positions.put(node.left, index - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                positions.put(node.right, index + 1);
            }
        }
        while (map.containsKey(minKey)) {
            ans.add(map.get(minKey++));
        }
        return ans;
    }
}
