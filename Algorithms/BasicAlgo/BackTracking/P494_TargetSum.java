package BasicAlgo.BackTracking;

public class P494_TargetSum {
    //2^n
    private int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0);
        return ans;
    }

    private void dfs(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                ans++;
            }
            return;
        }

        dfs(nums, target + nums[index], index + 1);
        dfs(nums, target - nums[index], index + 1);
    }
}
