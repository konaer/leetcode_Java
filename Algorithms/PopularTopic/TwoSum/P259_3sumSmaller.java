package PopularTopic.TwoSum;

import java.util.Arrays;

public class P259_3sumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    ans += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
