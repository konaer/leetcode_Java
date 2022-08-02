package PopularTopic.String.Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class P32_LongestValidParentheses {
    
    //use stack 
    //o(n) o(n)
    public int longestValidParentheses(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return ans;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }

    //two pass 解法
    //o(n)
    //o(1)
    public int longestValidParentheses2(String s) {
        int left = 0, right = 0, ans = 0;
        for (int i = 0; i < s.length(); i++ ) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, 2 * left);
            } else if (left < right) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (right == left) {
                ans = Math.max(ans, right * 2);
            } else if (left > right) {
                right = left = 0;
            }
        }
        return ans;
    }
}
