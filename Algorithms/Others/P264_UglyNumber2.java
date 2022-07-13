package Others;

import java.util.*;

public class P264_UglyNumber2 {
    //从堆里加入一个元素logn级别，取一个元素0（1），得到第n个丑数需要n个循环
	//一共是nlogn
	//堆空间和 哈希集合空间都不会超过n，所以空间是n
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.offer(1L);
        int ans = -1;
        for (int i = 0; i < n; i++) {
            long cur = pq.poll();
            ans = (int) cur;
            for (int factor : factors) {
                if (!set.contains(factor * cur)) {
                    set.add(factor * cur);
                    pq.offer(factor * cur);
                }
            }
        }
        return ans;
    }
    

    //DP o(n)
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(Math.min(2 * dp[p2], 3 * dp[p3]), 5 * dp[p5]);
            if (dp[i] == 2 * dp[p2]) {
                p2++;
            } 
            if (dp[i] == 3 * dp[p3]) {
                p3++;
            } 
            if (dp[i] == 5 * dp[p5]){
                p5++;
            }
        }
        return dp[n];
    }
}
