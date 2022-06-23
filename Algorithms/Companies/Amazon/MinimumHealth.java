package Companies.Amazon;

//https://www.1point3acres.com/bbs/thread-905773-1-1.html
//https://www.desiqna.in/5061/amazon-oa-coding-questions-and-solutions-set-8-2022

public class MinimumHealth {
    public static int find(int[] nums , int k) {
        boolean armed = true;
        int ans = 0, maxNum = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (armed && nums[i] >= k) {
                ans += nums[i] - k;
                armed = false;
            } else {
                ans += nums[i];
            }
            maxNum = Math.max(maxNum, nums[i]);
        }
        return armed ? ans - maxNum + 1 : ans + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,7};
        int k = 5;
        System.out.println(find(nums, k));
    }
}
