package Google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// key is to record the start and end
// if the current start > prev end, then add prev to res, at the same time update start
// update end at every loop (use Math.max)
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start > end) {
                res.add(new Interval(start, end));
                start = cur.start;
            }
            end = Math.max(end, cur.end);
        }
        res.add(new Interval(start, end));
        return res;
    }
}