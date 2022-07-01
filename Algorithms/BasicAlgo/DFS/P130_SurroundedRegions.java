package BasicAlgo.DFS;

public class P130_SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }

        for (int j = 1; j < m - 1; j++) {
            if (board[j][0] == 'O') {
                dfs(board, j, 0);
            }
            if (board[j][n - 1] == 'O') {
                dfs(board, j, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
