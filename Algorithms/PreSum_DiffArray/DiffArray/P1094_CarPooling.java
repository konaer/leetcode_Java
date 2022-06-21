package PreSum_DiffArray.DiffArray;

import java.util.*;

public class P1094_CarPooling {
    //差分数列
    //time o(n)
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1003];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }

        int people = 0;
        for (int num : diff) {
            people += num;
            if (people > capacity) {
                return false;
            }
        }
        return true;
    }

    //扫描线解法
    //时间 nlogn
    public boolean carPooling2(int[][] trips, int capacity) {
        List<int[]> list = new ArrayList<>();
        for (int[] trip : trips) {
            list.add(new int[]{trip[1], trip[0]});
            list.add(new int[]{trip[2], -trip[0]});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int people = 0;
        for (int[] point : list) {
            people += point[1];
            if (people > capacity) {
                return false;
            }
        }
        return true;
    }
}
