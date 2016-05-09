package Google;

import java.util.Deque;
import java.util.LinkedList;

// a better idea is do bfs for each level and do dfs in the bfs function
// the dist is only prev + 1, so use recursion is easy
// use stack/deque/linkedlist is slower

public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
		if (rooms == null) {
			return;
		}
		int row = rooms.length;
		if (row == 0) {
			return;
		}
		int col = rooms[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (rooms[i][j] == 0) {
					bfs(rooms, i, j, 0);
				}
			}
		}
	}

	private void bfs(int[][] rooms, int i, int j, int dist) {
		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < dist) {
			return;
		}
		rooms[i][j] = dist;
		bfs(rooms, i + 1, j, dist + 1);
		bfs(rooms, i - 1, j, dist + 1);
		bfs(rooms, i, j + 1, dist + 1);
		bfs(rooms, i, j - 1, dist + 1);
	}

	private int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public void wallsAndGates2(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
			return;
		}
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					bfs2(rooms, i, j);
				}
			}
		}
	}

	private void bfs2(int[][] a, int i, int j) {
		Deque<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			int dist = a[cur[0]][cur[1]] + 1;
			for (int[] d : dir) {
				int x = cur[0] + d[0];
				int y = cur[1] + d[1];

				if (isValid(a, x, y, dist)) {

					a[x][y] = dist;
					queue.offer(new int[] { x, y });
				}
			}
		}
	}

	private boolean isValid(int[][] a, int x, int y, int dist) {
		return x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] != -1 && a[x][y] > dist;
	}
}