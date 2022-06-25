package BasicAlgo.BackTracking;

import java.util.*;

public class P78_Subsets {
    // o(2^n)
    // space n
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;

    }

    private void dfs(int[] nums, int index) {
        ans.add(new ArrayList<>(list));
        for (int i = index ; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
