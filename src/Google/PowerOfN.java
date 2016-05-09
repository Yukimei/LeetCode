package Google;

// notice that we need to consider even/odd, positive/ negative n!
// negative n is (1/x) ^ n
public class PowerOfN {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		double half = myPow(x, Math.abs(n / 2));
		if (n < 0) {
			half = 1 / half;
			x = 1 / x;
		}

		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}

	public double myPow2(double x, int n) {
		double result = 1.0;
		for (int i = n; i != 0; i /= 2, x *= x) {
			if (i % 2 != 0) {
				result *= x;
			}
		}
		return n < 0 ? 1.0 / result : result;
	}
}