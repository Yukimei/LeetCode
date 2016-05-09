package Math;

/**
 * 
 * @author YingXue Mei
 * 		   
 *         Basically, it is the bits of oval A exclude bits of oval
 *         B.
 * 
 *         Assumptions:
 * 
 *         1. oval B's width is 7/8 of oval A's width, oval B's height is 3/4 of
 *         oval A's height (the approximation provided by the sample
 * 
 *         2. Use rX as semi-major axes, rY as semi-minor axes of oval A
 * 
 *         formulation for oval A is : 
 *         rY ^ 2 * (x - rX) + rX ^ 2 * (y - rY) =  rY ^ 2 * rX ^ 2.
 * 
 *         3. Use rXX as semi-major axes, rYY as semi-minor, the ratio of rXX to
 *         rX and rYY to rY is estimated by the sample of question 
 *         rXX = ( 7 / 8) * rX, rYY = (3 / 4) * rY
 * 
 *         The center of oval B is estimated by the sample of the question The
 *         formulation for oval B is : 
 *         (rXX - rX * 7/4) ^ 2 + (rYY - 3 / 2 * rY) = rYY ^ 2 * rXX ^ 2
 * 
 *         4. Since we have two formulation of ovals, we can just include all
 *         the bits which are inside oval A and not in oval B.
 * 
 *         5. The algorithm use symmetry of an oval to cast into four of 1/4
 *         oval each time
 */
public class Swoosh {
	private static final int[][] dir = { { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };

	public static void drawSwoosh(int width) {
		// width cannot be less than 1.
		if (width <= 1)
			return;
		// define the height of oval A
		int height = width / 2;
		// store the logo bit.
		boolean[][] res = new boolean[height + 1][width + 1];
		// oval A's semi-minor axes is rY, and semi-major axes is rX.
		int rX = width / 2, rY = height / 2;

		// if we define rY ^ 2 * x + rX ^ 2 * y = rY ^ 2 * rX ^ 2, then target =
		// rY ^ 2 * rX ^ 2.
		double target = Math.pow(rX, 2) * Math.pow(rY, 2);

		// mark all the bits that in oval a : rY ^ 2 * (x + rX) + rX ^ 2 * (y +
		// rY) = rY ^ 2 * rX ^ 2.
		for (int y = rY; y >= 0; y--) {
			for (int x = 0; x <= rX; x++) {
				// if the bit is inside the oval, set it to true.
				if (Math.pow(rY * x, 2) + Math.pow(rX * y, 2) <= target) {
					// using the symmetry of oval, we can just go through a
					// quarter of oval.
					res[y + rY][x + rX] = true;
					res[-y + rY][x + rX] = true;
					res[y + rY][-x + rX] = true;
					res[-y + rY][-x + rX] = true;
				}
			}
		}

		// Oval B's the semi-major axe is rX * (7 / 8), the semi-minor axe is rY
		// * ( 3 / 4)
		int rXX = rX * 7 / 8, rYY = rY * 3 / 4;
		double target2 = Math.pow(rXX, 2) * Math.pow(rYY, 2);
		// mark all the bits that in oval B :
		// (rXX - rX * 7/4) ^ 2 + (rYY - 3 / 2 * rY) <= rYY ^ 2 * rXX ^ 2
		
		for (int y = rYY - 1; y >= 0; y--) {
			for (int x = 0; x <= rXX; x++) {
				// if it inside the bits array and also inside the oval B
				if (Math.pow(rYY * x, 2) + Math.pow(rXX * y, 2) <= target2) {
					// using the symmetry of oval, we can just go through a
					// quarter of oval.
					for (int[] d : dir) {
						int curY = d[0] * y + rY * 3 / 2; // locate oval B to
															// the correct
															// center
						int curX = d[1] * x + rX * 7 / 4;
						if (valid(curY, res.length, curX, res[0].length)) {
							res[curY][curX] = false;
						}
					}
				}
			}
		}
		// print the logo based on our marked bits.
		for (int i = 1; i < height; i++) {
			for (int j = 1; j < width; j++) {
				if (res[i][j]) {
					System.out.print("X ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}

	}
	// make sure that the index of oval B is in the current width and won't be out of bound
	private static boolean valid(int a, int height, int b, int width) {
		return a >= 0 && a < height && b >= 0 && b < width;
	}

	public static void main(String[] args) {
		drawSwoosh(16);
		System.out.println();
		System.out.println();
		drawSwoosh(32);
		System.out.println();
		System.out.println();
		drawSwoosh(48);

	}

}
