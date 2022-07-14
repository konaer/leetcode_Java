package PopularTopic.String.Palindrome;

public class P680_ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return (isValid(s, l + 1, r) || isValid(s, l, r - 1));
            }
        }
        return true;
    }
    
    private boolean isValid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
