package Google;

import java.util.ArrayList;
import java.util.List;

//key is equals, if odd, start= end, else start = end + 1;
public class SprialOrderTraversal {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int top = 0, down = matrix.length - 1;
		int left = 0, right = matrix[0].length - 1;
		while (top < down && left < right) {
			for (int i = left; i < right; i++) {
				res.add(matrix[top][i]);

			}
			for (int i = top; i < down; i++) {
				res.add(matrix[i][right]);
			}
			for (int i = right; i > left; i--) {
				res.add(matrix[down][i]);
			}
			for (int i = down; i > top; i--) {
				res.add(matrix[i][left]);
			}
			left++;
			right--;
			top++;
			down--;
		}
		// key is here, if odd, start= end, else start = end + 1;
		if (left == right) {
			for (int i = top; i <= down; i++) {
				res.add(matrix[i][left]);
			}
		} else if (top == down) {
			for (int i = left; i <= right; i++) {
				res.add(matrix[top][i]);
			}
		}
		return res;
	}
}