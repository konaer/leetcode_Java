package PopularTopic.String.Parentheses;

public class P921_MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } 
            if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return left + right;
    }
}
