package PopularTopic.TwoSum;

import java.util.Arrays;

public class P16_3SumClosest {
    //n^2
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                } 
            }
        }
        return ans;
    }
}
