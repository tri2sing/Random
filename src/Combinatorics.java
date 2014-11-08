import java.util.*;

public class Combinatorics {
	
	/**
	 * Function to implement n choose k.
	 * @param n
	 * @param k
	 * @return
	 */
	public static int choose (int n, int k) {
		int res = 1;
		
		for (int i = 0; i < k; i++) {
			res *= (n - i);
			res /= (i + 1);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println ("4 choose 2 = " + Combinatorics.choose(4, 2));
		System.out.println ("6 choose 2 = " + Combinatorics.choose(6, 2));
	}

}
