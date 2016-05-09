package Google;

import java.util.Iterator;

//key is to use cache to store the peek value
//when next() is called, remember to reset cache to null!
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iter;
	Integer cache = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (cache == null) {
			cache = iter.next();
		}
		return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (cache != null) {
			Integer tmp = cache;
			cache = null;
			return tmp;

		}
		return iter.next();

	}

	@Override
	public boolean hasNext() {
		return cache != null || iter.hasNext();
	}
}