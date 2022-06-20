package MonotonicStack;

import java.util.*;

public class P84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i] = heights[i];
        }
        heights = newHeights;

        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                ans = Math.max(ans, height * width);
            }
            stack.push(i);
        }
        return ans;
    }
}
