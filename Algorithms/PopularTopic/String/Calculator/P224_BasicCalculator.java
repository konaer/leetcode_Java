package PopularTopic.String.Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class P224_BasicCalculator {
    //o(n)
    private int i = 0;

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char ops = '+';
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == '(') {
                num = calculate(s);
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (i == s.length() || c == '+' || c == '-' || c == ')') {
                if (ops == '+') {
                    stack.push(num);
                } else {
                    stack.push(-num);
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
