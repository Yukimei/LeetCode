package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
	public int minTotalDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		List<Integer> xlist = new ArrayList<>();
		List<Integer> ylist = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					xlist.add(i);
					ylist.add(j);
				}
			}
		}
		Collections.sort(xlist);
		Collections.sort(ylist);
		int min = 0;
		int start = 0, end = xlist.size() - 1;
		while (start < end) {
			min += (xlist.get(end) - xlist.get(start)) + (ylist.get(end) - ylist.get(start));
			start++;
			end--;
		}
		return min;
	}

	// naive solution (don't use this)
	public int minTotalDistance2(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		List<Element> list = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					list.add(new Element(i, j));
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int dist = getDist(i, j, list);
				min = Math.min(dist, min);
			}
		}
		return min;
	}

	private int getDist(int x, int y, List<Element> list) {
		int dist = 0;
		for (Element e : list) {
			dist += Math.abs(x - e.x) + Math.abs(y - e.y);
		}
		return dist;
	}

	class Element {
		int x;
		int y;

		Element(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
