package BasicAlgo.TwoPointer;

public class P75_SortColor {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        //注意是小于等于right，因为right每次都往前多走一个位置，这个位置的数字并没有被判断
        for (int i = 0; i <= r; i++) {
            if (nums[i] == 0) {
                swap(nums, l++, i);
            } else if (nums[i] == 2) {
                swap(nums, r--, i);
                i--;
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
