package BasicAlgo.BackTracking;

import java.util.*;

public class P46_Permutations {
    //time n * n!;
    //space n
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited);
        return ans;
    }

    private void dfs(int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
