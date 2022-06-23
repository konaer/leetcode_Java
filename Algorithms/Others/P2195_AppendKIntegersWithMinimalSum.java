package Others;

import java.util.Arrays;

public class P2195_AppendKIntegersWithMinimalSum {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        
        long ans = 0;
        int start = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > start) {
                int count = nums[i] - start >= k ? k : nums[i] - start;
                ans += (long) (start + start + count - 1) * count / 2; 
                k -= count;
            }
            //注意这里，需要加一个
            start = nums[i] + 1;
        }

        if (k > 0) {
            ans += (long) (start + start + k - 1) * k / 2;
        }
        return ans;
    }
}
