package Companies.Amazon;

//https://www.1point3acres.com/bbs/thread-905616-1-1.html

class solution {
    public static int find(int[] nums) {
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] && nums[i - 1] != nums[i - 2]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0, 1};
        System.out.println(find(nums));
    }
}