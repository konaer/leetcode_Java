package SlidingWindow;

import java.util.*;

public class P159_LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, ans = 0;
        while (r < s.length()) {
            char c = s.charAt(r++);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
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