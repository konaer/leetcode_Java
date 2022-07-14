package BasicAlgo.BFS;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P505_TheMaze2 {
    //time mnlog(mn)  heap log(mn), bfs最差mn，bfs嵌套 heap
    
    public int shortestDistance(int[][] maze, int[] start, int[] de) {
        int m = maze.length, n = maze[0].length;
        int[][] distances = new int[m][n];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distances[start[0]][start[1]] = 0;
        dijistra(maze, start, distances);
        return distances[de[0]][de[1]] == Integer.MAX_VALUE ? -1 : distances[de[0]][de[1]];
    }

    private void dijistra(int[][] maze, int[] start, int[][] distances) {
        int[] dir = {1, 0, -1, 0, 1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (distances[cur[0]][cur[1]] < cur[2]) {
                continue;
            }
            for (int i = 0; i < dir.length - 1; i++) {
                int x = cur[0] + dir[i];
                int y = cur[1] + dir[i + 1];
                int count = 0;
                while (isValid(maze, x, y) && maze[x][y] != 1) {
                    x += dir[i];
                    y += dir[i + 1];
                    count++;
                }
                x -= dir[i];
                y -= dir[i + 1];
                if (distances[x][y] > distances[cur[0]][cur[1]] + count) {
                    distances[x][y] = distances[cur[0]][cur[1]] + count;
                    pq.offer(new int[]{x, y, distances[x][y]});
                }
            }
        }
    }

    private boolean isValid(int[][] maze, int i, int j) {
        if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length) {
            return false;
        }
        return true;
    }
}