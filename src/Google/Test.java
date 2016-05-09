package Google;

public class Test {
	private int count = 0;

	private int f(int x) {
		count++;
		if (x < 1)
			return 1;
		else
			return f(x - 1) + g(x / 2);
	}

	private int g(int x) {
		count++;
		if (x < 2)
			return 2;
		else
			return f(x - 1) + g(x / 2);
	}

	public static void main(String[] args) {
		int[][] a = new int[300][];
		int[] b = new int[15];
		a[0] = b;
	}
}
