import java.util.ArrayList;


public class DynamicProgramming {

	private static int[][] calculateLCSLengths(String X, int lengthX, String Y, int lengthY) {
		int[][] lengths = new int[lengthX + 1][lengthY + 1];

		for (int i = 0; i < lengthX + 1; i++)
			lengths[i][0] = 0;
		for (int j = 0; j < lengthY + 1; j++) {
			lengths[0][j] = 0;
		}

		for (int i = 1; i < lengthX + 1; i++) {
			for (int j = 1; j < lengthY + 1; j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					lengths[i][j] = lengths[i - 1][j - 1] + 1;
				} else {
					lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
				}
			}
		}
		return lengths;
	}

	private static String backtrackLCSLengths(int[][] lengths, String X, int i, String Y, int j) {
		if (i == 0 || j == 0)
			return "";
		else if (X.charAt(i - 1) == Y.charAt(j - 1))
			return backtrackLCSLengths(lengths, X, i - 1, Y, j - 1) + X.charAt(i - 1);
		else {
			if (lengths[i][j - 1] > lengths[i - 1][j])
				return backtrackLCSLengths(lengths, X, i, Y, j - 1);
			else {
				return backtrackLCSLengths(lengths, X, i - 1, Y, j);
			}
		}
	}

	public static String getLongestCommonSubsequence(String X, String Y) {
		int lengthX = X.length();
		int lengthY = Y.length();
		int[][] lengths = calculateLCSLengths(X, X.length(), Y, Y.length());
		String lcs = backtrackLCSLengths(lengths, X, lengthX, Y, lengthY);
		System.out.format("X = %s, Y = %s, LCS = %s\n", X, Y, lcs);
		return lcs;
	}

	private static <T> ArrayList<T> backtrackLCSLengths(int[][] lengths, T[] X, int i, T[] Y, int j) {
		if (i == 0 || j == 0)
			return new ArrayList<T>();
		else if (X[i - 1].equals(Y[j - 1]))  {
			ArrayList<T> answer =  backtrackLCSLengths(lengths, X, i - 1, Y, j - 1);
			answer.add(X[i - 1]);
			return answer;
		}
		else {
			if (lengths[i][j - 1] > lengths[i - 1][j])
				return backtrackLCSLengths(lengths, X, i, Y, j - 1);
			else {
				return backtrackLCSLengths(lengths, X, i - 1, Y, j);
			}
		}
	}
	
	private static <T> int[][] calculateLCSLengths(T[] X, int lengthX, T[] Y, int lengthY) {
		int[][] lengths = new int[lengthX + 1][lengthY + 1];

		for (int i = 0; i < lengthX + 1; i++)
			lengths[i][0] = 0;
		for (int j = 0; j < lengthY + 1; j++) {
			lengths[0][j] = 0;
		}

		for (int i = 1; i < lengthX + 1; i++) {
			for (int j = 1; j < lengthY + 1; j++) {
				if (X[i - 1].equals(Y[j - 1])) {
					lengths[i][j] = lengths[i - 1][j - 1] + 1;
				} else {
					lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
				}
			}
		}
		return lengths;
	}
	
	public static <T> ArrayList<T> getLongestCommonSubsequence(T[] X, T[] Y) {
		int lengthX = X.length;
		int lengthY = Y.length;
		int[][] lengths = calculateLCSLengths(X, lengthX, Y, lengthY);
		ArrayList<T> answer = backtrackLCSLengths(lengths, X, lengthX, Y, lengthY);
		return answer;
	}
	
	public static <T> void printArray(T[] array) {
		for(T element: array) {
			System.out.print(element + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		String result = DynamicProgramming.getLongestCommonSubsequence("AGCAT", "GAC");
		result = DynamicProgramming.getLongestCommonSubsequence("ABAZDC", "BACBAD");
		result = DynamicProgramming.getLongestCommonSubsequence("ABCDGH", "AEDFHR");
		result = DynamicProgramming.getLongestCommonSubsequence("AGGTAB", "GXTXAYB");

		Integer[] array1 = {1, 2, 3, 4, 5, 6};
		Integer[] array2 = {2, 4, 5, 6};
		ArrayList<Integer> result2 = DynamicProgramming.getLongestCommonSubsequence(array1, array2);
		DynamicProgramming.printArray(array1);
		DynamicProgramming.printArray(array2);
		System.out.println(result2);
		
		Character[] array3 = {'A', 'G', 'C', 'A', 'T'};
		Character[] array4 = {'G', 'A', 'C'};
		ArrayList<Character> result3 = DynamicProgramming.getLongestCommonSubsequence(array3, array4);
		DynamicProgramming.printArray(array3);
		DynamicProgramming.printArray(array4);
		System.out.println(result3);
		
		
	}

}
