package PopularTopic.Array.TopK;

import java.util.*;

public class P347_TopKFrequentElements {
    //nlogk
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()) {
            pq.offer(key);
            while (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    //bucket sort 0(n)
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int key : map.keySet()) {
            int fre = map.get(key);
            bucket.get(fre).add(key);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = bucket.size() - 1; i >= 0 && ans.size() < k; i--) {
            ans.addAll(bucket.get(i));
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
