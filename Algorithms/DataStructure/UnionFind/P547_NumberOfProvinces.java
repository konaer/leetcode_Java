public class P547_NumberOfProvinces {
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = n;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && uf.find(i) != uf.find(j)) {
                    uf.union(i, j);
                    ans--;
                }
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
    }
}
