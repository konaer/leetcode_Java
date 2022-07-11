package BasicAlgo.Sorting;

import java.util.*;


public class P1636_SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            if (map.get(a) == map.get(b)) {
                return b.compareTo(a);
            } else {
                return map.get(a) - map.get(b);
            }
        });
        return list.stream().mapToInt(i -> i).toArray();
    }
}