package Google;

public class NumberOfIslands {
	// dfs 这个会改变原地图 但是可以保证复杂度是 O(n)
	private int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					removeIsland(grid, i, j);
				}
			}
		}
		return count;
	}

	private void removeIsland(char[][] grid, int x, int y) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
			return;
		}
		if (grid[x][y] == '1') {
			grid[x][y] = '0';
			for (int[] di : d) {
				removeIsland(grid, x + di[0], y + di[1]);
			}
		}
	}

	// union find
	public int numIslands2(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		// innit root[]
		int row = grid.length;
		int col = grid[0].length;
		int[] root = new int[row * col];
		for (int i = 0; i < row * col; i++) {
			if (grid[i / col][i % col] == '1') {
				root[i] = i;
			} else {
				root[i] = -1;
			}
		}
		// union
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					if (i > 0 && grid[i - 1][j] == '1') {
						int root1 = findRoot((i - 1) * col + j, root);
						int root2 = findRoot(i * col + j, root);
						if (root1 != root2) {
							root[root2] = root1;
						}
					}
					if (j > 0 && grid[i][j - 1] == '1') {
						int root1 = findRoot(i * col + j - 1, root);
						int root2 = findRoot(i * col + j, root);
						if (root1 != root2) {
							root[root2] = root1;
						}
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < root.length; i++) {
			if (root[i] == i) {
				count++;
			}
		}
		return count;
	}

	// union find with path compress;
	private int findRoot(int i, int[] root) {
		while (i != root[i]) {
			root[i] = root[root[i]];
			i = root[i];
		}
		return i;
	}

	public static void main(String[] args) {

	}
}