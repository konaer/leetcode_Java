package PopularTopic.String.Palindrome;

public class P5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1] == true)) {
                    if (end - start < j - i) {
                        start = i;
                        end = j;
                    }
                    dp[i][j] = true;
                }
            }
        }
        return s.substring(start, end + 1); 
    }
}