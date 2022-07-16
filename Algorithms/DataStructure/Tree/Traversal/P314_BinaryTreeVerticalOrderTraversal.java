package DataStructure.Tree.Traversal;

import java.util.*;

public class P314_BinaryTreeVerticalOrderTraversal {
    
    List<int[]> nodes = new ArrayList<>();
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        dfs(root, 0);
        Collections.sort(nodes, (a, b) -> a[1] - b[1]);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= nodes.size(); i++) {
            if (i != 0 || nodes.get(i)[0] != nodes.get(i - 1)[0] || i == nodes.size()) {
                ans.add(list);
                list.clear();
            } else {
                list.add(nodes.get(i)[1]);
            } 
        }
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        nodes.add(new int[]{level, root.val});
        dfs(root.left, level - 1);
        dfs(root.right, level + 1);
    }
}
