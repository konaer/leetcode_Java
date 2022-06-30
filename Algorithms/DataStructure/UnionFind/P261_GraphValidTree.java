package DataStructure.UnionFind;

public class P261_GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int count = n;
        for (int[] edge : edges) {
            //树里面不能有环
            if (uf.isConnected(edge[0], edge[1])) {
                return false;
            }
            uf.union(edge[0], edge[1]);
            count--;
        }
        return count == 1;        
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
            if (rank[i] > rank[j]) {
                parents[j] = i;
            } else if (rank[j] > rank[i]) {
                parents[i] = j;
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
