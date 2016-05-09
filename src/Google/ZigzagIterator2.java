package Google;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Problem this has space o(N)
public class ZigzagIterator2 {
	List<Integer> iter;
	int index;

	public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
		iter = new ArrayList<>();
		Iterator<Integer> iter1 = v1.iterator();
		Iterator<Integer> iter2 = v2.iterator();
		while (iter1.hasNext() && iter2.hasNext()) {
			iter.add(iter1.next());
			iter.add(iter2.next());
		}
		while (iter1.hasNext()) {
			iter.add(iter1.next());
		}
		while (iter2.hasNext()) {
			iter.add(iter2.next());
		}
		index = iter.size() == 0 ? -1 : 0;
	}

	public int next() {
		return iter.get(index++);
	}

	public boolean hasNext() {
		return index != -1 && index < iter.size();
	}
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2); while (i.hasNext()) v[f()] =
 * i.next();
 */
