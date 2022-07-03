package BasicAlgo.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class P490_TheMaze {
    //时间遍历时间 m*n
	//space m*n, matrix and queue space
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[] dir = {1, 0, -1, 0, 1};
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start[0] * n + start[1]);
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / n;
            int j = cur % n;
            if (i == destination[0] && j == destination[1]) {
                return true;
            }
            for (int k = 0; k < dir.length - 1; k++) {
                int ni = i + dir[k];
                int nj = j + dir[k + 1];
                while (isValid(maze, ni, nj) && maze[ni][nj] != 1) {
                    ni += dir[k];
                    nj += dir[k + 1];
                }
                ni -= dir[k];
                nj -= dir[k + 1];
                if (!visited[ni][nj]) {
                    queue.offer(ni * n + nj);
                    visited[ni][nj] = true;
                }
            }
        }
        return false;

    }

    private boolean isValid(int[][] maze, int i, int j) {
        if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length) {
            return false;
        }
        return true;
    }
}
