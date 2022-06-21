package MonotoincQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class P1438_LongestContinumsSubarrayWithAbsoluteDiffLessThanK {
    //两个单调栈 o(n)
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int index = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            //不能有=号，如果相同，应该都加到队列里，否则后面出队列的时候会影响，比如有两个2，
            //如果没都加进队列里，出去一个，就都没了
            while (!maxDeque.isEmpty() && nums[i] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && nums[i] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            maxDeque.offerLast(nums[i]);
            minDeque.offerLast(nums[i]);

            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[index] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                if (nums[index] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }
                index++;
            }
            ans = Math.max(ans, i - index + 1);
        }
        return ans;
    }

    //TreeMap nlogn
    public int longestSubarray2(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int l = 0, r = 0, ans = 0;
        while (r < nums.length) {
            int num = nums[r++];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                int leftNum = nums[l++];
                map.put(leftNum, map.get(leftNum) - 1);
                if (map.get(leftNum) == 0) {
                    map.remove(leftNum);
                }
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
