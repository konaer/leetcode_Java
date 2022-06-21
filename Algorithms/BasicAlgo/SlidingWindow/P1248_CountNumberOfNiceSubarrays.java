package BasicAlgo.SlidingWindow;

public class P1248_CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return findMostK(nums, k) - findMostK(nums, k - 1);
    }

    private int findMostK(int[] nums, int k) {
        int l = 0, r = 0, ans = 0;
        while (r < nums.length) {
            int num = nums[r++];
            if (num % 2 == 1) {
                k--;
            }
            while (k < 0) {
                int leftNum = nums[l++];
                if (leftNum % 2 == 1) {
                    k++;
                }
            }
            ans += r - l;
        }
        return ans;
    }
}
