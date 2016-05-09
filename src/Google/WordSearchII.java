package Google;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if (board == null || board.length == 0 || board[0].length == 0 || words.length == 0) {
			return res;
		}
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// dfs fron each i, j
				dfs(board, root, i, j, res);
			}
		}
		return res;
	}

	private void dfs(char[][] board, TrieNode root, int i, int j, List<String> res) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return;
		}
		char c = board[i][j];
		if (c == '#' || root.child[c - 'a'] == null) { // check if visited or if
														// it is in the trie
														// dict
			return;
		}
		board[i][j] = '#'; // mark as visited
		root = root.child[c - 'a'];
		if (root.word != null) {
			res.add(root.word); // add word
			root.word = null; // deduplicate add
		}

		dfs(board, root, i - 1, j, res);
		dfs(board, root, i + 1, j, res);
		dfs(board, root, i, j - 1, res);
		dfs(board, root, i, j + 1, res);

		board[i][j] = c; // recover to original (unvisited)
	}

	// build trie dictionary
	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String s : words) {
			TrieNode cur = root;
			for (char c : s.toCharArray()) {
				if (cur.child[c - 'a'] == null) {
					cur.child[c - 'a'] = new TrieNode();
				}
				cur = cur.child[c - 'a'];
			}
			cur.word = s;
		}
		return root;
	}

	class TrieNode {
		String word;
		TrieNode[] child = new TrieNode[26];
	}
}