package BasicAlgo.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class P395_LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        for (int i = 1; i <= 26; i++) {
            int l = 0, r = 0, count = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (r < s.length()) {
                char c = s.charAt(r++);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == k) {
                    count++;
                }
                while (map.size() > i) {
                    char ch = s.charAt(l++);
                    if (map.get(ch) == k) {
                        count--;
                    }
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                }    
                if (map.size() == i && map.size() == count) {
                    ans = Math.max(ans, r - l);
                }
            }
        }
        return ans;
    }
}
