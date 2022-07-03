package PopularTopic.String.Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class P772_BasicCalculator3 {
    
    private int i = 0;
    
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char ops = '+';
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == '(') {
                num = calculate(s);
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (i == s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')') {
                if (ops == '+') {
                    stack.push(num);
                }
                if (ops == '-') {
                    stack.push(-num);
                }
                if (ops == '*') {
                    stack.push(stack.pop() * num);
                }
                if (ops == '/') {
                    stack.push(stack.pop() / num);
                }
                ops = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }
        return stack.stream().mapToInt(k -> k).sum();
    }
}
