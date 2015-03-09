/**
 * Template for HackerRank submission to read input. 
 * 
 */

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
            int [] arr = new int [N];
            for (int j = 0; j < N; j++) 
                arr[i] = in.nextInt ();
		}
		in.close();
	}

}
