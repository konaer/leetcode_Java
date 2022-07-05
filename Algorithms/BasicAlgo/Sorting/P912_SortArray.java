package BasicAlgo.Sorting;

public class P912_SortArray {
    //QuickSort
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int index = randomPartition(nums, l, r);
        quickSort(nums, l, index - 1);
        quickSort(nums, index + 1, r);
    }

    private int randomPartition(int[] nums, int l, int r) {
        int index = (int) (Math.random() * (r - l + 1) + l);
        swap(nums, index, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int wall = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, wall++);
            }
        }
        swap(nums, wall, r);
        return wall;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //mergeSort
    public int[] sortArray2(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int[] divide(int[] nums, int l, int r) {
        if (l == r) {
            return new int[]{nums[l]};
        }
        int mid = (r - l) / 2 + l;
        int[] left = divide(nums, l, mid);
        int[] right = divide(nums, mid + 1, r);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] ans = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                ans[k++] = left[i++];
            } else {
                ans[k++] = right[j++];
            }
        }
        while (i < left.length) {
            ans[k++] = left[i++];
        }
        while (j < right.length) {
            ans[k++] = right[j++];
        }
        return ans;
    }
}
