package BasicAlgo.MonotonicStack;

import java.util.*;


public class P739_DailyTemperatures {
    public int[] dailyTemperatures(int[] tems) {
        int n = tems.length;
        int ans[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && tems[i] >= tems[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
