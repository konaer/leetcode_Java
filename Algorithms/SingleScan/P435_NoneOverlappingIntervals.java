package SingleScan;

import java.util.Arrays;

public class P435_NoneOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = 0, last = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
        	if (interval[0] < last) {
        		ans++;
        	} else {
        		last = interval[1];
        	}	
        }
        return ans;
    }
}
