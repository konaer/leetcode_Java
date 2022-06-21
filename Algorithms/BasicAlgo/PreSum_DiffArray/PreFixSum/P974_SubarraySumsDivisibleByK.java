package BasicAlgo.PreSum_DiffArray.PreFixSum;

import java.util.HashMap;
import java.util.Map;

public class P974_SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //注意这行非常重要，忘了好几次了
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            //注意这里，是为了计算sum是负数的情况
            int mod = (sum % k + k) % k;
            if (map.containsKey(mod)) {
                ans += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}
