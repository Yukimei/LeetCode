package BackTracking;

public class WordDictionary {
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            } 
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root, 0);
    }
    
    public boolean search(String s, TrieNode root, int i) {
        if (root == null) {
            return false;
        } else if (i == s.length()) {
            return root.word != null;
        }
        char c = s.charAt(i);
            if (c == '.') {
                boolean flag = false;
                for (int j = 0; j < 26; j++) {
                    flag = search(s, root.children[j], i + 1) ? true : flag;
                }
                return flag;
            } else {
                return search(s, root.children[c - 'a'], i + 1);
            }
        }
    class TrieNode {
        String word = null;
        TrieNode[] children = new TrieNode[26];
    }
    
}
    

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");