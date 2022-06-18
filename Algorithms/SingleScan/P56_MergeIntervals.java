package SingleScan;

import java.util.*;

public class P56_MergeIntervals {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		List<int[]> ans = new ArrayList<>();
		
		int[] last = intervals[0];
		ans.add(last);
		for (int i = 1; i < intervals.length; i++) {
			last = ans.get(ans.size() - 1);
			int[] cur = intervals[i];
			if (cur[0] > last[1]) {
				ans.add(cur);
			} else {
				last[1] = Math.max(last[1], cur[1]);
			}
		}
		return ans.toArray(new int[ans.size()][]);
    }
}
