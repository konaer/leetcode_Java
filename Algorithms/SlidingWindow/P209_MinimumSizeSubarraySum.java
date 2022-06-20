package SlidingWindow;

public class P209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int sum = 0, ans = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= target) {
                ans = Math.min(ans, r - l);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
