package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class P992_SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findMostK(nums, k) - findMostK(nums, k - 1);
    }

    private int findMostK(int[] nums, int k) {
        int l = 0, r= 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            int num = nums[r++];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.size() > k) {
                int leftNum = nums[l++];
                map.put(leftNum, map.get(leftNum) - 1);
                if (map.get(leftNum) == 0) {
                    map.remove(leftNum);
                } 
            }
            ans += r - l;
        }
        return ans;
    }
}
