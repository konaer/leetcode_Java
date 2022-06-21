package SweepLine;

import java.util.*;


public class P1229_MeetingSchedular {
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
		
		int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
        	int start = Math.max(slots1[i][0], slots2[j][0]);
        	int end = Math.min(slots1[i][1], slots2[j][1]);
        	if (end - start >= duration) {
        		return List.of(start, start + duration);
        	} else {
        		if (slots1[i][1] < slots2[j][1]) {
        			i++;
        		} else {
        			j++;
        		}
        	}
        }
        return new ArrayList<>();
    }
	
	//use PriorityQueue
	//重点是，有交集就是分属不同的两个人了，所以可以把它们放在一个stack里面
	public List<Integer> minAvailableDuration2(int[][] slots1, int[][] slots2, int duration) {
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int[] slot : slots1) {
			if (slot[1] - slot[0] >= duration) {
				heap.offer(slot);
			}
		}
		
		for (int[] slot : slots2) {
			if (slot[1] - slot[0] >= duration) {
				heap.offer(slot);
			}
		}
		
		//注意这了是>1,不是isEmpty,否则下面的peek会越界
		while (heap.size() > 1) {
			int[] slot1 = heap.poll();
			int[] slot2 = heap.peek();
			if (slot1[1] - slot2[0] >= duration) {
				return List.of(slot2[0], slot2[0] + duration);
			}
		}
		return new ArrayList<>();
	}
}
