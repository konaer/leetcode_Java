package PopularTopic.String.Palindrome;

public class P647_PalindromeSubstring {
    //n^2
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1] == true)) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
