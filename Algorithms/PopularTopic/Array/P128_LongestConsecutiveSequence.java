package PopularTopic.Array;

import java.util.*;

public class P128_LongestConsecutiveSequence {
    //time o(n) 
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            //因为判断了这个，所以不是最开头的，都跳过了，所以降到了o(n)
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 1;
            while (set.contains(++num)) {
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
