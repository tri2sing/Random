import java.util.*;

/**
 * 
 * @author Sameer Adhikari
 * Input: Two lines each containing a string
 * Output: The minimum number of characters to delete from the two strings,
 *  such that they become anagrams of each other
 *  Constraints: The strings are only lower case English letters
 */

public class AnagramDeletions {
	
	private static final int N = 26;
	
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();

		char [] a1 = s1.toCharArray();
		char [] a2 = s2.toCharArray(); 
		int [] counts = new int [N];

		int base = Character.getNumericValue('a');

		for (int k = 0; k < a1.length; k++) {
			int index = Character.getNumericValue(a1[k]) - base;
			counts[index]++;
		}
			
		for (int l = 0; l < a2.length; l++) {
			int index = Character.getNumericValue(a2[l]) - base;
			counts[index]--;
		}
		
		int deletions = 0;
		for (int m = 0; m < N; m++) {
			deletions += Math.abs(counts[m]);
		}
		
		System.out.println(deletions);
		in.close();
		}
}