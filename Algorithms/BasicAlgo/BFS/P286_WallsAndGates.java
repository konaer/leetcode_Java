package BasicAlgo.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class P286_WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        int[] dir = {1, 0, -1, 0 ,1};
        int EMPTY = Integer.MAX_VALUE;
        int m = rooms.length, n = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * n + j);
                }
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / n;
            int j = cur % n;
            for (int k = 0; k < dir.length - 1; k++) {
                int ni = i + dir[k];
                int nj = j + dir[k + 1];
                if (isValid(m, n, ni, nj) && rooms[ni][nj] == EMPTY) {
                    rooms[ni][nj] = rooms[i][j] + 1;
                    queue.offer(ni * n + nj);
                }
            }
        }
    }

    private boolean isValid(int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        return true;
    }
}
