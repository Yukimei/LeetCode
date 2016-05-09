package Google;

import java.util.Iterator;
import java.util.List;

// space O(1)
public class ZigzagIterator {
	Iterator<Integer> iter1;
	Iterator<Integer> iter2;
	int count = 0;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		iter1 = v1.iterator();
		iter2 = v2.iterator();
	}

	public int next() {
		count++;
		if (!hasNext()) {
			return -1;
		}
		if (!iter2.hasNext() || count % 2 == 1 && iter1.hasNext()) {
			return iter1.next();
		} else {
			return iter2.next();
		}
	}

	public boolean hasNext() {
		return iter1.hasNext() || iter2.hasNext();
	}
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2); while (i.hasNext()) v[f()] =
 * i.next();
 */
