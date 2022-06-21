package BasicAlgo.MonotonicStack;

import java.util.*;

public class P496_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums1.length; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums1[i]) {
                stack.pop();
            }
            int greaterElement = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums1[i], greaterElement);
            stack.push(nums1[i]);
        }

        int[] ans = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            ans[i] = map.get(nums2[i]);
        }
        return ans;
    }
}
