public class P323_NumberOfConnectedComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int ans = n;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.isConnected(edge[0], edge[1])) {
                uf.union(edge[0], edge[1]);
                ans--;
            }
        }
        return ans;
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
            if (rank[i] < rank[j]) {
                parents[i] = j;
            } else if (rank[i] > rank[j]) {
                parents[j] = i;
            } else {
                parents[i] = j;
                rank[j]++;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
