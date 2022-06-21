package BasicAlgo.SweepLine;


import java.util.ArrayList;
import java.util.List;

public class P1272_RemoveInterval {
	public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		List<List<Integer>> list = new ArrayList<>();
        for (int[] interval : intervals) {
        	if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
        		list.add(List.of(interval[0], interval[1]));
        	} else {
        		if (interval[0] < toBeRemoved[0]) {
        			list.add(List.of(interval[0], toBeRemoved[0]));
        		}
        		if (interval[1] > toBeRemoved[1]) {
        			list.add(List.of(toBeRemoved[1], interval[1]));
        		}
        	} 
        }
        return list;
    }
}
