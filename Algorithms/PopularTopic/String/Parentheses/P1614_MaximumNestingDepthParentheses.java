package PopularTopic.String.Parentheses;

public class P1614_MaximumNestingDepthParentheses {
    public int maxDepth(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
