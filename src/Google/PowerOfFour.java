package Google;

//The first two conditions are for power of 2. 
//One additional condition: (num-1) can be divided by 3.
public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
		return (num & (num - 1)) == 0 && num > 0 && (num - 1) % 3 == 0;
	}

	public boolean isPowerOfFour2(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
		// 0x55555555 is to get rid of those power of 2 but not power of 4
		// so that the single 1 bit always appears at the odd position
	}
}
