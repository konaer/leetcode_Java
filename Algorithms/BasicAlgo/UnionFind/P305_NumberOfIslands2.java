import java.util.*;

public class P305_NumberOfIslands2 {
    
    private final static int[] dir = {1, 0, -1, 0, 1};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m * n);
        boolean[] visited = new boolean[m * n];
        int count = 0;

        List<Integer> ans = new ArrayList<>();
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            int index = x * n + y;
            if (!visited[index]) {
                count++;
                visited[index] = true;
                for (int i = 0; i < dir.length - 1; i++) {
                    int nx = x + dir[i];
                    int ny = y + dir[i + 1];
                    int nIndex = nx * n + ny;
                    if (isValid(nx, ny, m, n) && visited[nIndex] && !uf.isConnected(index, nIndex)) {
                        uf.union(index, nIndex);
                        count--;
                    }
                } 
            }
            ans.add(count);
        }
        return ans;    
    }

    private boolean isValid(int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return true;
    }

    class UnionFind {
        private int[] parents;
        private int[] rank;

        public UnionFind(int n) {
            this.parents = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                rank[i] = 0;
            }
        }
        
        //o(1)
        public int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        //o(logn)
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] < rank[rootY]) {
                parents[rootX] = rootY; 
            } else if (rank[rootX] > rank[rootY]) {
                parents[rootY] = rootX;
            } else {
                parents[rootX] = rootY;
                rank[rootY]++;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
