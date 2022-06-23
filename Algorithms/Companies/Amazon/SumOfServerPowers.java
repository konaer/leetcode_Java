package Companies.Amazon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//https://leetcode.com/discuss/interview-question/1706805/Amazon-OA-Question-Is-there-an-O(n)
//https://leetcode.com/discuss/interview-question/1736639/Solution-to-Amazon-OA-2022-problem-Sum-of-Scores-of-Subarray

//https://www.1point3acres.com/bbs/thread-905616-1-1.html

public class SumOfServerPowers {
    public static int find(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }

        System.out.println(Arrays.toString(preSum));

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int minNum = nums[i];
            for (int j = i; j < nums.length; j++) {
                minNum = Math.min(minNum, nums[j]);
                System.out.println("minNum = " + minNum);
                ans += minNum * (preSum[j + 1] - preSum[i]);
                System.out.println();
                System.out.println("ans= " + ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4};
        System.out.println(find(nums));
    }
}
