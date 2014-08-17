import java.util.*;

public class ArrayProblems {

	private static int kthTwoArrays(int[] a, int al, int ar, int[] b, int bl,
			int br, int k) {

		if (b[bl] > a[ar]) { // If all the elements of a are smaller than the
								// smallest b
			if (k <= ar - al + 1) // If k fits within a
				return a[k - 1];
			else
				return b[k - 1 - (ar - al + 1)];
		}
		if (a[al] > b[br]) { // If all the elements of b are smaller than the
								// smallest a
			if (k <= br - bl + 1)// If k fits within b
				return b[k - 1];
			else
				return a[k - 1 - (br - bl + 1)];
		}

		return 0;

	}

	public static int kthTwoArrays(int[] a, int[] b, int k) {
		return ArrayProblems.kthTwoArrays(a, 0, a.length - 1, b, 0,
				b.length - 1, k);
	}

	/*
	 * Finds whether a specified element exists in a sorted array that has been
	 * rotated unknown number of times and does not have duplicates.
	 * 
	 * @param arr an array that has sorted elements rotated some times
	 * 
	 * @param target the element to find in the array
	 * 
	 * @return the location of the element if found, -1 otherwise
	 */

	public static int binarySearchRotatedArray(int[] arr, int target) {

		int L = 0;
		int R = arr.length - 1;
		while (L <= R) {
			int M = L + (R - L) / 2;
			if (arr[M] == target)
				return M;
			if (arr[L] <= arr[M]) { // Left half is sorted
				if (arr[L] <= target && target < arr[M])
					R = M - 1;
				else
					L = M + 1;
			} else { // Right half is sorted
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
	 * 
	 * @param diff the value of the difference to check for among array elements
	 */
	public static void findDiffExists(int[] arr, int diff) {

		if (arr == null)
			throw new IllegalArgumentException();

		System.out.println("Diff = " + diff);

		int len = arr.length;
		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = 0; i < len; i++) {
			hs.add(arr[i]);
		}

		for (int i = 0; i < len; i++) {
			if (hs.contains(arr[i] - diff)) {
				System.out.println(arr[i] + ", " + (arr[i] - diff));
			}
		}
		System.out.println();
	}

	/*
	 * Prints the indices of the two array elements that have the given sum
	 */

	public static void indicesSumExists(int[] a, int M) {
		int N = a.length;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> l;

		for (int j = 0; j < N; j++) {
			if (map.containsKey(a[j])) {
				l = map.get(a[j]);
			} else {
				l = new ArrayList<Integer>();
			}
			l.add(j);
			map.put(a[j], l);
		}

		// Check if two of the values in the array sum to M
		for (int j = 0; j < N; j++) {
			int dif = M - a[j];
			if (dif != a[j]) {
				if (map.containsKey(dif)) {
					l = map.get(dif);
					int loc1 = j + 1;
					int loc2 = l.get(0) + 1;
					System.out.println(loc1 + " " + loc2);
					break;
				}
			} else {
				if (map.containsKey(dif)) {
					l = map.get(dif);
					if (l.size() > 1) {
						int loc1 = j + 1;
						int loc2 = l.get(1) + 1;
						System.out.println(loc1 + " " + loc2);
						break;
					}
				}

			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}

	// Partition the array such that elements less arr[pivot] are to its left
	// left and those greater than or equal to are to its right in the array
	// Returns the index where arr[pivot] finally ends up after the partition.
	private static int partition(int[] arr, int left, int right, int pivot) {
		int index = left;
		int pval = arr[pivot];

		swap(arr, pivot, right); // Move pivot to the end.
		for (int i = left; i < right; i++) {
			if (arr[i] < pval) {
				swap(arr, index, i);
				index++;
			}
		}
		swap(arr, index, right);
		//printArray(arr);
		return index;
	}

	private static int quickSelect(int[] arr, int first, int last, int kth) {
		if (first == last)
			return arr[first];
		int pivot = first;
		int index = partition(arr, first, last, pivot);
		if (index == kth) return arr[index];
		else if (kth < index) return quickSelect(arr, first, index - 1, kth);
		else return quickSelect(arr, index + 1, last, kth);
	}

	/*
	 * Finds the Kth element in an array without full sort
	 */

	public static int quickSelect(int[] arr, int kth) {
		if (arr == null || arr.length <= kth || kth < 0)
			throw new IllegalArgumentException();
		return quickSelect(arr, 0, arr.length - 1, kth - 1);
	}

	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.print("]");
		System.out.println();
	}

	public static void main(String[] args) {

		/*
		 * int [] arr = {10, 20, 30, 40, 15}; ArrayProblems.findDiffExists(arr,
		 * 10); ArrayProblems.findDiffExists(arr, -10);
		 * ArrayProblems.findDiffExists(arr, 0);
		 * ArrayProblems.findDiffExists(arr, -1);
		 */

		int[] arr1 = { 7, 8, 9, 0, 1, 2, 3, 4, 5, 6 };
		/*
		System.out.print("Searching ");
		ArrayProblems.printArray(arr1);
		System.out.println("2 is located at "
				+ ArrayProblems.binarySearchRotatedArray(arr1, 2));
		System.out.println("10 is located at "
				+ ArrayProblems.binarySearchRotatedArray(arr1, 10));
		
		
		System.out.println ("5th element is = " + ArrayProblems.quickSelect(arr1, 5));
		System.out.println ("1st element is = " + ArrayProblems.quickSelect(arr1, 1));
		System.out.println ("8th element is = " + ArrayProblems.quickSelect(arr1, 8));
		
		*/
		
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(N);
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = in.nextInt();
        int median = quickSelect (arr, (N + 1)/2);
        System.out.println (median);
        Arrays.sort(arr);
        System.out.println(arr[(N - 1)/2]);
		in.close();
	}

}
