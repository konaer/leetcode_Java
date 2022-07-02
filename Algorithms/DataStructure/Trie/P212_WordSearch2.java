package DataStructure.Trie;

import java.util.*;

public class P212_WordSearch2 {
    
    private Set<String> set = new HashSet<>();
    private boolean[][] visited;
    
    public List<String> findWords(char[][] board, String[] words) {
        visited = new boolean[board.length][board[0].length];
        Trie trie = new Trie();
        
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie, "");
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, int i, int j, Trie trie, String pre) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }

        pre += board[i][j];
        
        if (!trie.isPre(pre)) {
            return;
        }

        if (trie.search(pre)) {
            set.add(pre);
        }
        visited[i][j] = true;
        dfs(board, i + 1, j, trie, pre);
        dfs(board, i - 1, j, trie, pre);
        dfs(board, i, j + 1, trie, pre);
        dfs(board, i, j - 1, trie, pre);
        visited[i][j] = false;
    }



    class Trie {
        private Trie[] children = new Trie[26];
        private boolean isWord = false;
        
        public Trie() {
            this.children = new Trie[26];
            this.isWord = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
        
        public boolean search(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.isWord;
        }

        public boolean isPre(String pre) {
            Trie node = this;
            for (char c : pre.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;
        }
    }
}
