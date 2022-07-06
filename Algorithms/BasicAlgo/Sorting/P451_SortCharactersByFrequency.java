package BasicAlgo.Sorting;

import java.util.*;

public class P451_SortCharactersByFrequency {
    //o(n)  桶排可以达到n
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<List<Character>> bucket = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            bucket.add(new ArrayList<>());
        }
        for (char c : map.keySet()) {
            int frequent = map.get(c);
            bucket.get(frequent).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.size() - 1; i > 0; i--) {
            for (char c : bucket.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}