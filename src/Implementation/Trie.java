package Implementation;

class TrieNode {
	// Initialize your data structure here.
	TrieNode[] children;
	boolean isWord;

	public TrieNode() {
		children = new TrieNode[26];
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - 'a';
			if (cur.children[c] == null) {
				cur.children[c] = new TrieNode();
			}
			cur = cur.children[c];
		}
		cur.isWord = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - 'a';
			if (cur.children[c] == null) {
				return false;
			}
			cur = cur.children[c];
		}
		return cur.isWord;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			int c = prefix.charAt(i) - 'a';
			if (cur.children[c] == null) {
				return false;
			}
			cur = cur.children[c];
		}
		return true;
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
