
public class BitOps {

	public static int parity(long x) {
		int res = 0;
		while (x > 0) {
			res ^= (x & 1);
			x >>= 1;
		}
		return res;
	}

	/**
	 * Function to swap two bits of a long integer. The LSB is bit 0.
	 * 
	 * @param x
	 *            number to swap the bits of.
	 * @param i
	 *            bit i that is swapped with j
	 * @param j
	 *            bit j that i swapped with i
	 * @return the new integer after the swap
	 */

	public static long swap(long x, int i, int j) {
		// swap only if if the ith and jth bit are different
		if (((x >> i) & 1) != ((x >> j) & 1)) {
			x ^= (1L << i) | (1L << j);
		}
		return x;
	}

	/**
	 * Function to reverse the bits of an integer
	 * 
	 * @param x
	 *            the integer to perform the reverse on
	 * @return the new integer resulting from the reverse
	 */

	public static long reverse(long x) {
		long res = 0;
		for (int i = 0; i < 64; i++) {  // Do not use a test of x > 0
			res <<= 1;
			res |= (x & 1);
			x >>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bit parity for -1 = " + BitOps.parity(-1));
		System.out.println("Bit parity for 3 = " + BitOps.parity(3));
		System.out.println("Bit parity for 6 = " + BitOps.parity(6));
		System.out.println("Bit parity for 7 = " + BitOps.parity(7));

		System.out.println("Swap bit 1 & 6 of 73 = " + BitOps.swap(73, 1, 6));
		
		System.out.println ("My reverse of 1 =   " + BitOps.reverse(1L));
		System.out.println ("Java reverse of 1 = " + Long.reverse(1L));
		System.out.println ("My reverse of 3 =   " + BitOps.reverse(3L));
		System.out.println ("Java reverse of 3 = " + Long.reverse(3L));
		System.out.println ("My reverse of 6 =   " + BitOps.reverse(6L));
		System.out.println ("Java reverse of 6 = " + Long.reverse(6L));
		System.out.println ("My reverse of 11 =   " + BitOps.reverse(11L));
		System.out.println ("Java reverse of 11 = " + Long.reverse(11L));


	}

}
