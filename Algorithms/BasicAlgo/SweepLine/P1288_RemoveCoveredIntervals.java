package BasicAlgo.SweepLine;


import java.util.*;

public class P1288_RemoveCoveredIntervals {
	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a,  b) -> a[0] == b[0]? b[1] - a[1] : a[0] - b[0]);
        int ans = 0, last = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[1] > last) {
                ans++;
                last = interval[1];
            }
        }
        return ans;
    }
}
