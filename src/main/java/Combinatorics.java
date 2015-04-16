import java.util.LinkedList;

public class Combinatorics {
	
	// Placeholder for function to write
	public <T> LinkedList<T> subsets(LinkedList<T> input) {
		LinkedList<T> results = null;
		
		return results;
	}

	// Placeholder for function to write
	public <T> LinkedList<T> combinations(LinkedList<T> input) {
		LinkedList<T> results = null;
		
		return results;
	}

	// Placeholder for function to write
	public <T> LinkedList<T> permutations(LinkedList<T> input) {
		LinkedList<T> results = null;
		
		return results;
	}
	

	/**
	 * Function to implement n choose k.
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static int choose(int n, int k) {
		int res = 1;

		for (int i = 0; i < k; i++) {
			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}

	/**
	 * Generates all combinations of the characters in the given string. All the characters are distinct.
	 * Note: It will generate duplicate results if input characters have repeats.

	 * @param input the given input string.
	 */
	public static void combinations(String input) {
		combinations(input, "");
		System.out.println();
	}

	/**
	 * Generates combinations of asked for length for the characters in the given string. All the characters are distinct.
	 * Note: It will generate duplicate results if input characters have repeats.

	 * @param input the given input string.
	 */
	public static void combinations(String input, int k) {
		combinations(input, "", k);
		System.out.println();
	}

	private static void combinations(String input, String prefix) {
		int N = input.length();
		if (!"".equals(prefix))
			System.out.print(prefix + ", ");
		for (int i = 0; i < N; i++) {
			combinations(input.substring(i + 1), prefix + input.charAt(i));
		}
	}

	private static void combinations(String input, String prefix, int k) {

		if (k == 0)
			System.out.print(prefix + ", ");

		int N = input.length();
		for (int i = 0; i < N; i++) {
			combinations(input.substring(i + 1), prefix + input.charAt(i), k - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("4 choose 2 = " + Combinatorics.choose(4, 2));
		System.out.println("6 choose 2 = " + Combinatorics.choose(6, 2));

		Combinatorics.combinations("abcd");
		Combinatorics.combinations("abcd", 2);
		Combinatorics.combinations("abcd", 3);
		Combinatorics.combinations("abcd", 4);

		Combinatorics.combinations("aaab");
		Combinatorics.combinations("aaab", 2);
		Combinatorics.combinations("aaab", 3);
		Combinatorics.combinations("aaab", 4);

	}

}
