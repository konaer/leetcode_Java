package PopularTopic.Array.TopK;

import java.lang.runtime.SwitchBootstraps;
import java.util.PriorityQueue;

public class P215_KthLargestElementArray {
    //使用pq
    //nlogk
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    //quick select
    //average o(n) worst o(n^2)
    public int findKthLargest2(int[] nums, int k) {
        helper(nums, k, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void helper(int[] nums, int k, int l, int r) {
        if (l >= r) {
            return;
        }
        int index = randomPartition(nums, l, r);
        if (index == nums.length - k) {
            return;
        } else if (index < nums.length - k) {
            helper(nums, k, index + 1, r);
        } else {
            helper(nums, k, l, index - 1);
        }
        
    }

    private int randomPartition(int[] nums, int l, int r) {
        int index = (int)(Math.random() * (r - l + 1) + l);
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
}
