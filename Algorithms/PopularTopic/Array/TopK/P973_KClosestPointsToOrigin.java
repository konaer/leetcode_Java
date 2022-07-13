package PopularTopic.Array.TopK;

import java.util.PriorityQueue;

public class P973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return getDistance(b) - getDistance(a);
        });
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
    
    private int getDistance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
