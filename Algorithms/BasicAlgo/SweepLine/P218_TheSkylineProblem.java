package BasicAlgo.SweepLine;

import java.util.*;

public class P218_TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Integer> lines = new ArrayList<>();
        for (int[] building : buildings) {
            lines.add(building[0]);
            lines.add(building[1]);
        }

        Collections.sort(lines);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for (int line : lines) {
            while (index < buildings.length && buildings[index][0] <= line) {
                pq.offer(new int[]{buildings[index][1], buildings[index][2]});
                index++;
            }
            while (!pq.isEmpty() && pq.peek()[0] <= line) {
                pq.poll();
            } 
            int height = (pq.isEmpty() ? 0 : pq.peek()[1]);
            if (ans.size() == 0 || ans.get(ans.size() - 1).get(1) != height) {
                ans.add(List.of(line, height));
            }
        }
        return ans;
    }
}

