package DataStructure.Trie;

public class P211_DesignAddSearchWordsDataStructure {

}

class WordDictionary {
    
    private Trie root;
    
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Trie();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length()) {
            return node.isWord;
        }
        
        char c = word.charAt(index);
        if (c != '.') {
            if (node.children[c - 'a'] == null) {
                return false;
            } else {
                return dfs(word, index + 1, node.children[c - 'a']);
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && dfs(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        }
    }
    
    private class Trie {
        private Trie[] children = new Trie[26];
        private boolean isWord = false;
    }
}