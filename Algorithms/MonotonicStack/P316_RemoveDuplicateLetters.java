package MonotonicStack;

import java.util.*;

public class P316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[128];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i)] = i;
        }

        Set<Character> visited = new HashSet<>();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && c <= stack.peek() && i < last[stack.peek()]) {
                visited.remove(stack.pop());
            }
            visited.add(c);
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.insert(0, c);
        }
        return sb.toString();
    }
}
