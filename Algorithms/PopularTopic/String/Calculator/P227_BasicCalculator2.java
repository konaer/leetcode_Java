package PopularTopic.String.Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class P227_BasicCalculator2 {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char ops = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (i == s.length() - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
                if (ops == '+') {
                    stack.push(num);
                } else if (ops == '-') {
                    stack.push(-num);
                } else if (ops == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                ops = c;
                num = 0;
            }
        }
        return stack.stream().mapToInt(i -> i).sum();
    }
}
