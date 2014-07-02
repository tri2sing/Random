import java.util.HashSet;

public class ArrayProblems {

	/*
	 * Finds whether a specified element exists in a sorted array that has
	 * been rotated unknown number of times and does not have duplicates.
	 * 
	 * @param arr an array that has sorted elements rotated some times
	 * @param target the element to find in the array
	 * @return the location of the element if found, -1 otherwise
	 */
	
	public static int binarySearchRotatedArray(int [] arr, int target) {
		
		int L = 0;
		int R = arr.length - 1;
		while (L <= R) {
			int M = L + (R - L)/2;
			if(arr[M] == target) return M;
			if (arr[L] <= arr[M]) {  // Left half is sorted
				if (arr[L] <= target && target < arr[M])
					R = M - 1;
				else
					L = M + 1;
			}
			else {  // Right half is sorted
				if (arr[M] <= target && target <= arr[R])
					L = M + 1;
				else
					R = M - 1;
			}
		}
		return -1;
		
	}
	/*
	 * Prints out the elements of an array that have the specified difference.
	 * 
	 * @param arr an array containing integers to check for the difference
	 * @param diff the value of the difference to check for among array elements
	 * 
	 */
	public static void findDiffExists (int [] arr, int diff) {
	
		if (arr == null) throw new IllegalArgumentException ();
		
		System.out.println ("Diff = " + diff);
		
		int len = arr.length;
		HashSet<Integer> hs = new HashSet<Integer> (); 
		
		for (int i = 0; i < len; i ++) {
			hs.add(arr[i]);
		}
		
		for (int i = 0; i < len; i++) {
			if (hs.contains(arr[i] - diff)) {
				System.out.println (arr[i] + ", " + (arr[i] - diff));
			}
		}
		System.out.println();
	}
	
	public static void printArray(int[] arr) {
		System.out.print("[");
		for(int n: arr) {
			System.out.print(n + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static void main(String[] args) {

		/*
		int [] arr = {10, 20, 30, 40, 15};
		ArrayProblems.findDiffExists(arr, 10);
		ArrayProblems.findDiffExists(arr, -10);
		ArrayProblems.findDiffExists(arr, 0);
		ArrayProblems.findDiffExists(arr, -1);
		*/

		int[] arr1 = {7, 8, 9, 0, 1, 2, 3, 4, 5, 6};
		System.out.print("Searching ");
		ArrayProblems.printArray(arr1);
		System.out.println("2 is located at " + ArrayProblems.binarySearchRotatedArray(arr1, 2));
		System.out.println("10 is located at " + ArrayProblems.binarySearchRotatedArray(arr1, 10));
	}

}
