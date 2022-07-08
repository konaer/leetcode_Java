package PopularTopic.TwoSum;

import java.util.*;

public class P170_TwoSum3Structure {
    
}

class TwoSum {

    private Map<Integer, Integer> map;

    public TwoSum() {
        this.map = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for (int key : map.keySet()) {
            int count = map.getOrDefault(value - key, 0);
            if (count >= 2 || (count == 1 && key * 2 != value)) {
                return true;
            }
        }
        return false;
    }
}
