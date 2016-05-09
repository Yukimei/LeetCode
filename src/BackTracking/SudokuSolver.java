package BackTracking;

public class SudokuSolver {
	//key 在于是从left to right
	//所以recursion的时候有两个index值， x和y
	public void solveSudoku(char[][] board) {
		boolean[][] h = new boolean[9][9];
		boolean[][] v = new boolean[9][9];
		boolean[][] c = new boolean[9][9];
		isFound = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int k = i / 3 * 3 + j / 3;

					int num = board[i][j] - '0' - 1;

					h[i][num] = true;
					v[j][num] = true;
					c[k][num] = true;
				}
			}
		}

		dfs(board, 0, 0, c, h, v);
		return;
	}

	boolean isFound;

	private void dfs(char[][] board, int x, int y, boolean[][] c, boolean[][] h, boolean[][] v) {
		if (isFound) {
			return;
		}
		if (x == 9) {
			isFound = true;
			return;
		}
		int z = x / 3 * 3 + y / 3;

		if (board[x][y] == '.') {
			for (int num = 0; num < 9; num++) {

				if (h[x][num] || v[y][num] || c[z][num]) {
					continue;
				}

				board[x][y] = (char) (num + '1');
				h[x][num] = true;
				v[y][num] = true;
				c[z][num] = true;

				if (y + 1 < 9) {
					dfs(board, x, y + 1, c, h, v);
				} else {
					dfs(board, x + 1, 0, c, h, v);
				}
				if (isFound) {
					return;
				}
				board[x][y] = '.';
				h[x][num] = false;
				v[y][num] = false;
				c[z][num] = false;
			}
		} else {
			int num = board[x][y] -'0' - 1;
			h[x][num] = true;
			v[y][num] = true;
			c[z][num] = true;
			if (y + 1 < 9) {
				dfs(board, x, y + 1, c, h, v);
			} else {
				dfs(board, x + 1, 0, c, h, v);
			}
		}
	}

	// below use bit manipulation
	// public void solveSudoku(char[][] board) {
	// long[] c = new long[9];
	// long[] h = new long[9];
	// long[] v = new long[9];
	// for (int i = 0; i < board.length; i++) {
	// for (int j = 0; j < board[0].length; j++) {
	// if (board[i][j] != '.') {
	// int num = board[i][j] - '0';
	// h[i] &= (1 << num);
	// v[j] &= (1 << num);
	// c[i / 3 * 3 + j / 3] &= (1 << num);
	// }
	// }
	// }
	//
	// dfs(board, 0, 0, c, h, v);
	// return;
	// }
	//
	// boolean isFound = false;
	//
	// private void dfs(char[][] board, int x, int y, long[] c, long[] h, long[]
	// v) {
	// if (x == board.length) {
	// isFound = true;
	// return;
	// }
	// int z = x / 3 * 3 + y / 3;
	// if (y < 9) {
	// if (board[x][y] == '.') {
	// for (int num = 1; num <= 9; num++) {
	//
	// if ((h[x] & (1 << num)) != 0 && (v[y] & (1 << num)) != 0 && (c[z] & (1 <<
	// num)) != 0) {
	// long hprev = h[x];
	// long vprev = v[y];
	// long cprev = c[z];
	//
	// board[x][y] = (char) (num + '0');
	// h[x] &= (1 << num);
	// v[y] &= (1 << num);
	// c[z] &= (1 << num);
	//
	// dfs(board, x, y + 1, c, h, v);
	// if (isFound) {
	// break;
	// }
	// board[x][y] = '.';
	// h[x] = hprev;
	// v[y] = vprev;
	// c[z] = cprev;
	// }
	// }
	// } else {
	// dfs(board, x, y + 1, c, h, v);
	// }
	// } else {
	// dfs(board, x + 1, 0, c, h, v);
	// }
	// }
}
