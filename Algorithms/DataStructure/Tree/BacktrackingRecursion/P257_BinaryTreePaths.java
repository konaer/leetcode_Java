package DataStructure.Tree.BacktrackingRecursion;

import java.util.*;

import DataStructure.Tree.TreeNode;

public class P257_BinaryTreePaths {
    //时间n^2， 因为是数组，一共n个节点，储存每个节点需要n时间
	//空间 n^2 , 最差情况n层，每层空间 n。最好情况logn层，空间 （logn）^2
    List<String> ans = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }

    private void dfs(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        path += node.val;
        if (node.left == null && node.right == null) {
            ans.add(path);
            return;
        }
        dfs(node.left, path + "->");
        dfs(node.right, path + "->");  
    }


    //自下而上
    //时间最差是n^2,所有的节点都在一侧。最好情况是 nLogN
    public List<String> binaryTreePaths2(TreeNode root) {
        return dfs(root);
    }

    private List<String> dfs(TreeNode node) {
        List<String> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        List<String> left = dfs(node.left);
        List<String> right = dfs(node.right);
        for (String path : left) {
            list.add(node.val + "->" + path);
        }
        for (String path : right) {
            list.add(node.val + "->" + path);
        }
        if (list.size() == 0) {
            list.add(String.valueOf(node.val));
        }
        return list;
    }
}
