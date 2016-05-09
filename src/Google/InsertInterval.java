package Google;

import java.util.ArrayList;
import java.util.List;
//step1: mark the new interval index for insert
//step2.insert the new interval
//key is to determine the insert index
// and use Math.min, Mathmax to determin the insert interval start and end
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (newInterval.start > cur.end) {
                res.add(cur);
                index++;
            } else if (newInterval.end < cur.start) {
                res.add(cur);
            } else {
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            }
        }
        res.add(index, newInterval);
        return res;
    }
	public List<Interval> insert2(List<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int s = -1;
		int e = -1;

		for (int i = 0; i < intervals.size(); i++) {
			if (s == -1 && newInterval.start <= intervals.get(i).end) {
				s = i;
			}
			if (newInterval.end >= intervals.get(i).start) {
				e = i;
			}
		}

		if (s == -1) {
			intervals.add(newInterval);
		} else if (e == -1) {
			intervals.add(0, newInterval);
		} else {
			int start = Math.min(intervals.get(s).start, newInterval.start);
			int end = Math.max(intervals.get(e).end, newInterval.end);
			intervals.subList(s, e + 1).clear();
			intervals.add(s, new Interval(start, end));
		}
		return intervals;
	}

}