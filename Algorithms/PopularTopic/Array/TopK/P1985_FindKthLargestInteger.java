package PopularTopic.Array.TopK;

import java.util.PriorityQueue;

public class P1985_FindKthLargestInteger {
    //o(mnlogn)  注意m是字符串长度，每次比较和交换的过程都需要m，一共nlogn次
    //这里因为是字符串，排序所需时间和integer不一样
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return a.length() - b.length();
            }
        });
        for (String num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
