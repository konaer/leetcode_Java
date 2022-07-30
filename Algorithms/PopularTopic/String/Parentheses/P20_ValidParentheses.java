package PopularTopic.String.Parentheses;

import java.util.*;

public class P20_ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || !stack.poll().equals(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
