package BackTracking;
// key is to mark it has been visited! and remove the visited mark when track back
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (exist(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, String word, int i, int j, int index) {
		if (index == word.length()) {
			return true;
		}
		if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) {
			return false;
		}
		board[i][j] = '*'; // marked it as visited
		boolean exist = exist(board, word, i - 1, j, index + 1) || exist(board, word, i + 1, j, index + 1)
				|| exist(board, word, i, j - 1, index + 1) || exist(board, word, i, j + 1, index + 1);
		board[i][j] = word.charAt(index);
		return exist;
	}
}
