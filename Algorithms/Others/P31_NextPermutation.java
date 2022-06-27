package Others;

public class P31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从最后面排，找到第一个不是升序的
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //如果存在，那么从最后面开始，后面找第一个比他大的，替换他
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
