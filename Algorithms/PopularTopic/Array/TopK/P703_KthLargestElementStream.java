package PopularTopic.Array.TopK;

import java.util.*;

public class P703_KthLargestElementStream {
}

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            pq.offer(num);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
