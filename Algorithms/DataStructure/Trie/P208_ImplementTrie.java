package DataStructure.Trie;

public class P208_ImplementTrie {

}

class Trie {
    private Trie[] children;
    private boolean isWord;
    
    public Trie() {
        this.children = new Trie[26];
        this.isWord = false;
    }
    
    //o(n)
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
    
    //o(n)
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
    
    //o(n)
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}