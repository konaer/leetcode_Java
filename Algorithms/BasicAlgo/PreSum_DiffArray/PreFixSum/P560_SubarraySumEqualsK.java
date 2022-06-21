package BasicAlgo.PreSum_DiffArray.PreFixSum;

import java.util.HashMap;
import java.util.Map;

public class P560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        //注意这里要先放一个0，否则array的第一个数算不进去
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
