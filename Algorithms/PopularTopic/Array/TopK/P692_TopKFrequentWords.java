package PopularTopic.Array.TopK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P692_TopKFrequentWords {
    //时间，n时间计算每个单词频率， 每个logk时间插入堆，一共n个，所以是nlogk
	//加起来就是 n + nlogk， 取nlogk
	//还要考虑字符串长度，取平均长度为l， 时间复杂度为 l(nlogk)
	//哈希表空间n，堆空间k，取大的，n
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) {
                return b.compareTo(a);
            } else {
                return map.get(a) - map.get(b);
            }
        });
        for (String key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(0, pq.poll());
        }
        return ans;
    }
}
