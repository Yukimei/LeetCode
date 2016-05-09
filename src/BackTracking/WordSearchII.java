package BackTracking;

import java.util.ArrayList;
import java.util.List;
// key is to use trie
// 1.trie represent the dictionary, so use a trie can easily find all the words
// 2. dfs from each node of the board
// 3. mark visited as '#'  OR other character
// 4. change back after all the recursion in the same level (backtrack to beginning status)
// 5. use word field to decide the end of the word and what the word is.
// 6. do the if ( ) { recursion} in the current level (can save time!)
// 7. when find a word , set the word filed of the trie node to null -> deduplication.
public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
			return res;
		}
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// dfs fron each i, j 
				dfs(board, i, j, root, res);
			}
		}
		return res;
	}

	private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
		char c = board[i][j];
		// check if it is visited and if it can form a word
		if (c == '#' || node.children[c - 'a'] == null) {
			return;
		}
		// mark visited
		board[i][j] = '#';
		node = node.children[c - 'a']; // go next node
		//check if it is a node, if so, add to the result
		if (node.word != null) { 
			res.add(node.word);
			node.word = null; // change the word field to deduplicate
		}
		
		//write if here to save time
		if (i > 0) {
			dfs(board, i - 1, j, node, res);
		}
		if (j > 0) {
			dfs(board, i, j - 1, node, res);
		}
		if (i < board.length - 1) {
			dfs(board, i + 1, j, node, res);
		}
		if (j < board[0].length - 1) {
			dfs(board, i, j + 1, node, res);
		}
		// retain to original status  (remove the visited mark at the end of the dfs of the current level)
		board[i][j] = c;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String s : words) {
			TrieNode cur = root;
			for (char c : s.toCharArray()) {
				int i = c - 'a';
				if (cur.children[i] == null) {
					cur.children[i] = new TrieNode();
				}
				cur = cur.children[i];
			}
			cur.word = s; // set word here to save time
		}
		return root;
	}

	class TrieNode {
		String word = null;
		TrieNode[] children = new TrieNode[26];
	}

}
