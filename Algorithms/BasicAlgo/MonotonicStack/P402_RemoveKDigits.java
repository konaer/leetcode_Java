package BasicAlgo.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class P402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }

        while (k > 0) {
            deque.pollLast();
            k--;
        }
        
        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}