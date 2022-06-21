package BasicAlgo.SlidingWindow;

public class P713_SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        
        int l = 0, r = 0, ans = 0;
        int product = 1;
        while (r < nums.length) {
            product *= nums[r++];
            while (product >= k) {
                product /= nums[l++];
            }
            ans += r - l;
        }
        return ans;
    }
}
