package BasicAlgo.SlidingWindow;

import java.util.*;

public class P3_LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        while (r < s.length()) {
            char c = s.charAt(r++);
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
