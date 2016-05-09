package Google;

public class SearchA2DMatrixII {
	// use binary search (key of binary search is deduct the unneeded part)
	// 1. start from 0 row, last col
	// 2. if the current val is larget than target, that means the how col
	// cannot have answer, so col--

	public boolean searchMatrix(int[][] matrix, int target) {
		int row = 0, col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}
}