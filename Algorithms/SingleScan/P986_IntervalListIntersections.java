package SingleScan;

import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P986_IntervalListIntersections {
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
        	int start = Math.max(firstList[i][0], secondList[j][0]);
        	int end = Math.min(firstList[i][1], secondList[j][1]);
            if (end - start >= 0) {
                ans.add(new int[]{start, end});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
