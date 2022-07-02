package BasicAlgo.DFS;

public class P79_WordSearch {
    //time mn*3^l, l是字符串长度
	//space mn
    private int[] dir = {1, 0, -1, 0, 1};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (board[i][j] == word.charAt(index)) {
            if (index == word.length() - 1) {
                return true;
            }
            
            visited[i][j] = true;
            for (int k = 0; k < dir.length - 1; k++) {
                int ni = i + dir[k];
                int nj = j + dir[k + 1];
                if (isValid(board, ni, nj) && !visited[ni][nj] && dfs(board, ni, nj, word, index + 1)) {
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        return true;
    }
}
