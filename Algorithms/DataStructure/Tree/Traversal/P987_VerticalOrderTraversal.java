package DataStructure.Tree.Traversal;
import java.util.*;
import DataStructure.Tree.TreeNode;;

public class P987_VerticalOrderTraversal {
    
    private List<int[]> list = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        Collections.sort(list, (a, b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        int index = Integer.MIN_VALUE;
        for (int[] node : list) {
            if (node[2] != index) {
                index = node[2];
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(node[0]);
        }
        return ans;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        list.add(new int[]{root.val, row, col});
        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}
