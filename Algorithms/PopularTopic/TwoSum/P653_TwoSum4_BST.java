package PopularTopic.TwoSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P653_TwoSum4_BST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //解法1，中序遍历
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l) + list.get(r) == k) {
                return true;
            } else if (list.get(l) + list.get(r) < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }


    //第二种解法，recursion
    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    
    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}
