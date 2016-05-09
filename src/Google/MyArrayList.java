package Google;

public class MyArrayList {
	private static final int DEFAULT_SIZE = 10;

	private int[] shortArray;
	private int[] longArray;
	int index;
	boolean first;
	int prevShortArrayLength = -1;

	MyArrayList() {
		shortArray = new int[DEFAULT_SIZE];
		longArray = new int[DEFAULT_SIZE * 2];
		index = -1;
		first = true;
	}

	MyArrayList(int size) {
		shortArray = new int[size];
		longArray = new int[size * 2];
		index = -1;
		first = true;
	}

	public void add(int val) {
		if (index >= shortArray.length - 1) {
			first = false;
			prevShortArrayLength = shortArray.length;
			shortArray = new int[longArray.length * 2];
		}
		shortArray[++index] = val;
		longArray[++index] = val;
		if (!first) {
			longArray[index - prevShortArrayLength] = shortArray[index - prevShortArrayLength];
		}
	}

	public int get(int index) {
		return shortArray[index];
	}

	public void add(int index, int val) {
		moveOneAfter(index);
		
	}
	
	private void moveOneAfter(int index) {
		for (int i = this.index; i > index; i++) {
			shortArray[i] = shortArray[i - 1];
			longArray[i] = longArray[i - 1];
		}
	}
	
	public void delete(int index) {
 
	}

}
