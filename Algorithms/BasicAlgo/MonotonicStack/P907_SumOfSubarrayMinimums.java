package BasicAlgo.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class P907_SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, mod = 1000000007;
        int[] left = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            //一个是>一个是>=，是为了避免两个都重复算到或者都算不到。现在都是左闭右开，都正好算到一次
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new ArrayDeque<>();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long)(i - left[i]) * (right[i] - i) * arr[i] % mod;
            ans %= mod;
        }
        return (int) ans;
    }
}
