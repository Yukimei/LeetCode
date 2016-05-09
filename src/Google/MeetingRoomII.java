package Google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */

// the key here is that if there is one start > end, then the meeting room
// doesn't count,
// (either merge the interval (using heap), or use the array (count++ only start
// < end)
public class MeetingRoomII {
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null) {
			return 0;
		}
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int room = 0, endIdx = 0;
		for (int i = 0; i < start.length; i++) {
			if (start[i] < end[endIdx]) {
				room++;
			} else {
				endIdx++;
			}
		}
		return room;
	}

	// another method
	public int minMeetingRooms2(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		// Sort the intervals by start time
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		// Use a min heap to track the minimum end time of merged intervals
		PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		});

		// start with the first meeting, put it to a meeting room
		heap.offer(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			// get the meeting room that finishes earliest
			Interval interval = heap.poll();

			if (intervals[i].start >= interval.end) {
				// if the current meeting starts right after
				// there's no need for a new room, merge the interval
				interval.end = intervals[i].end;
			} else {
				// otherwise, this meeting needs a new room
				heap.offer(intervals[i]);
			}

			// don't forget to put the meeting room back
			heap.offer(interval);
		}

		return heap.size();
	}

	public int minMeetingRooms3(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, (o1, o2) -> o1.start - o2.start);
		PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
		});
		minHeap.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			// poll the first end meeting room out
			Interval cur = minHeap.poll();
			if (intervals[i].start >= cur.end) {
				// merge
				cur.end = intervals[i].end;
			} else {
				minHeap.offer(intervals[i]);
			}
			minHeap.offer(cur);
		}
		return minHeap.size();

	}
}