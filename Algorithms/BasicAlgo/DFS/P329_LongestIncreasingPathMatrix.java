package BasicAlgo.DFS;

public class P329_LongestIncreasingPathMatrix {
    //o(mn)
    private int[][] cache;
    private int[] dir = {1, 0, -1, 0, 1};

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        cache = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }
    
    private int dfs(int[][] matrix, int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        cache[i][j] = 1;
        for (int k = 0; k < dir.length - 1; k++) {
            int ni = i + dir[k];
            int nj = j + dir[k + 1];
            if (isValid(matrix, ni, nj) && matrix[i][j] > matrix[ni][nj]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, ni, nj) + 1);
            }
        }
        return cache[i][j];
    }

    private boolean isValid(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return false;
        }
        return true;
    }
}
