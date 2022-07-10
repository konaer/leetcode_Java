package PopularTopic.TwoSum;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class P454_4sum2 {
    //o(n^2)
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            for (int y : nums2) {
                map.put(x + y, map.getOrDefault(x + y, 0) + 1);
            }
        }
        for (int x : nums3) {
            for (int y : nums4) {
                int target = 0 - x - y;
                ans += map.getOrDefault(target, 0);
            }
        }
        return ans;
    }
}
