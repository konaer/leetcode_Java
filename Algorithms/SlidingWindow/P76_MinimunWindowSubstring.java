package SlidingWindow;

import java.util.*;

public class P76_MinimunWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0, validCount = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r++);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    validCount++;
                }
                map.put(c, map.get(c) - 1);
            }
            while (validCount == t.length()) {
                if (r - l < minLen) {
                    minLen = r - l;
                    minStart = l;
                }
                char ch = s.charAt(l++);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) {
                        validCount--;
                    }
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minStart, minStart + minLen);
    }
}
