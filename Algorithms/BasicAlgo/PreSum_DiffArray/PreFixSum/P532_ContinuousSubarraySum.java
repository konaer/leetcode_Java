package BasicAlgo.PreSum_DiffArray.PreFixSum;

import java.util.HashMap;
import java.util.Map;

public class P532_ContinuousSubarraySum {
    //time n
    //space n
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (k == 0 && map.get(key) > 1) {
                ans++;
            }
            if (k > 0 && map.containsKey(key + k)) {
                ans++;
            }
        }
        return ans;
    }
}
