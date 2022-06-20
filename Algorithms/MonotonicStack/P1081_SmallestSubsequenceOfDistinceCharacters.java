package MonotonicStack;

import java.util.*;

public class P1081_SmallestSubsequenceOfDistinceCharacters {
    public String smallestSubsequence(String s) {
        int[] last = new int[128];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i)] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited[c]) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && i < last[stack.peek()]) {
                visited[stack.pop()] = false;
            }
            visited[c] = true;
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.insert(0, c);
        }
        return sb.toString();
    }
}
