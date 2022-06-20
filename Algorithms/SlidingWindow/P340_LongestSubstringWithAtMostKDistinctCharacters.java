package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class P340_LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0, r = 0, ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r++);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(l++);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
