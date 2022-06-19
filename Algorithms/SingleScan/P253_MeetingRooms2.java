package SingleScan;

import java.util.*;


public class P253_MeetingRooms2 {
	public int minMeetingRooms(int[][] intervals) {   
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
        	list.add(new int[]{interval[0], 1});
        	list.add(new int[]{interval[1], -1});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int ans = 0, count = 0;
        for (int[] point : list) {
        	count += point[1];
        	ans = Math.max(ans, count);
        }
        return ans;
    }

    public int minMeetingRooms(int[][] intervals) {   
        
    }


}
