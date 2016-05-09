package Google;

// you use the next bit to record the next generation information (1 for live)
// the current bit is current generation information
// use Math.min()  Math.max()   to confirm the boarder and use for loop to count easily
public class GameOfLife {
	public void gameOfLife(int[][] board) {
		if (board == null) {
			return;
		}
		int row = board.length, col = board[0].length;
		if (row == 0 || col == 0) {
			return;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) { // you use the next bit to record
											// the next generation information
											// (1 for live)
				// the current bit is current generation information
				int lives = getLives(board, row, col, i, j);
				if (board[i][j] == 1 && (lives == 2 || lives == 3)) {
					board[i][j] = 3;
					continue;
				}
				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2;
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] >>= 1;
			}
		}
	}

	private int getLives(int[][] board, int row, int col, int i, int j) {
		int lives = 0;
		// notice this to get the bound
		int si = Math.max(0, i - 1), ei = Math.min(row - 1, i + 1);
		int sj = Math.max(0, j - 1), ej = Math.min(col - 1, j + 1);
		for (int x = si; x <= ei; x++) {
			for (int y = sj; y <= ej; y++) {
				lives += board[x][y] & 1;
			}
		}
		lives -= board[i][j] & 1;
		return lives;
	}
}
