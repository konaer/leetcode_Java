package BasicAlgo.BackTracking;

import java.util.*;

public class P90_Subsets2 {
    //time 2^n
    //space n
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int index) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            //只要不是同一级就没问题
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
