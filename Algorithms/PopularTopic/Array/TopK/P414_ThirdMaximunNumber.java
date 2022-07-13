package PopularTopic.Array.TopK;

import java.util.TreeSet;

public class P414_ThirdMaximunNumber {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            while (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }
}
