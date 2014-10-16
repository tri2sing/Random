import java.util.*;

public class AnagramTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			String s = in.next();
			int l = s.length();
			if (l % 2 != 0)
				System.out.println("-1");
			else {
				int[] count = new int[26]; // 'a' == 0, 'b' == 1 'z' == 25
				for (int k = 0; k < 26; k++)
					count[k] = 0;

				char[] ca1 = s.substring(0, l / 2).toCharArray();
				char[] ca2 = s.substring(l / 2, l).toCharArray();

				for (int j = 0; j < l / 2; j++) {
					count[ca1[j] - 'a']++; // Count occurrence of a character in
											// first half
					count[ca2[j] - 'a']--; // DEcrement the occurrence of
											// character in second half
				}
				int diff = 0;
				for (int j = 0; j < 26; j++)
					diff += Math.abs(count[j]);
				diff /= 2;
				System.out.println(diff);
			}
		}
	}
}
