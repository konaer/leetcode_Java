package DataStructure.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class P827_MakingLargeIsland {
    public int largestIsland(int[][] grid) {
        int ans = 1;
        int n = grid.length;
        int[] dir = {1, 0, -1, 0, 1};
        UnionFind uf = new UnionFind(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int t = 0; t < dir.length - 1; t++) {
                        int ni = i + dir[t];
                        int nj = j + dir[t + 1];
                        if (isValid(n, ni, nj) && grid[ni][nj] == 1) {
                            uf.union(i * n + j, ni * n + nj);
                            ans = Math.max(ans, uf.size[uf.find(i * n + j)]);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int t = 0; t < dir.length - 1; t++) {
                        int ni = i + dir[t];
                        int nj = j + dir[t + 1];
                        if (isValid(n, ni, nj) && grid[ni][nj] == 1) {
                            int parent = uf.find(ni * n + nj);
                            map.put(parent, uf.size[parent]);
                        }
                    }
                    int newIsland = 1 + map.values().stream().mapToInt(k -> k).sum();
                    ans = Math.max(ans, newIsland);
                }
            }
        }
        return ans;
    }

    private boolean isValid(int n, int i,int j) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return false;
        }
        return true;
    }

    class UnionFind {
        private int[] parents;
        private int[] size;
        public UnionFind(int n) {
            this.parents = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public void union(int x, int y) {
            int i = find(x);
            int j = find(y);
            if (i == j) {
                return;
            }
            parents[i] = j;
            size[j] += size[i];
        }
    }
}
