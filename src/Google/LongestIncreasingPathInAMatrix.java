package Google;
//key to solve this is the cache is only records one comparasion 
// for example, only consider smaller from the four direction
public class LongestIncreasingPathInAMatrix {
	private int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] cache = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int len = dfs(i, j, matrix, cache);
				max = Math.max(len, max);
			}
		}
		return max;
	}

	private int dfs(int i, int j, int[][] matrix, int[][] cache) {
		if (cache[i][j] != 0) { // the memorization is here. if it is visited
								// before (that means it has been calculated the
								// largest of four directions)
			return cache[i][j];
		}
		int max = 1;
		for (int[] d : dir) {
			int x = d[0] + i, y = d[1] + j;
			if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
				continue;
			}
			int len = 1 + dfs(x, y, matrix, cache);
			max = Math.max(len, max);
		}
		cache[i][j] = max;
		return max;
	}
}
