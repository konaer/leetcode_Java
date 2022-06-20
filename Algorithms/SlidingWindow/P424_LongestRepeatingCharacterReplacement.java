package SlidingWindow;

public class P424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int l = 0, r =0, maxChar = 0;
        while (r < s.length()) {
            char c = s.charAt(r++);
            arr[c - 'A']++;
            maxChar = Math.max(maxChar, arr[c - 'A']);
            if (r - l > maxChar + k) {
                char ch = s.charAt(l++);
                arr[ch - 'A']--;
            }
        }
        return r - l;
    }
}