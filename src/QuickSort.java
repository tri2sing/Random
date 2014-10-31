import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class QuickSort {

	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	public static final int MEDIAN = 0;


	private static void swap(int [] array, int i, int j) {
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * 
	 * @param array the integers to partition around the pivot
	 * @param left the left index of the range to partition
	 * @param right the right index of the range to partition
	 * @param pivotIndex index of the array to use as pivot
	 * @return the index where the pivot element ends up at
	 */
	private static int partition (int [] array, int left, int right, int pivotIndex) {
		
		int pivotVal = array[pivotIndex];
		swap(array,  left,  pivotIndex); // Move pivot to the beginning of the array

		int rightmostChecked;
		int leftmostGreaterThanPivot = left + 1;  // Any element from this to the right is greater than pivot
		
		for(rightmostChecked = left + 1; rightmostChecked <= right; rightmostChecked++) {
			if(array[rightmostChecked] < pivotVal) {
				swap(array, rightmostChecked, leftmostGreaterThanPivot);
				leftmostGreaterThanPivot++;
			}
		}
		swap(array, left, leftmostGreaterThanPivot - 1);
		return leftmostGreaterThanPivot - 1;
	}
	
	/**
	 * 
	 * @param array the integer values to be sort
	 * @param choice LEFT, RIGHT, or MEDIAN value of the array to use as pivot
	 * @return the number of swaps performed by quick sort algorithm
	 */
	
	private static long sort(int [] array, int left, int right,  int choice) throws IllegalArgumentException {
		
		// An array of length 1 is already sorted,
		// and we do not need to perform any swaps
		if(left >= right) {
			return 0;
		}
		
		// Do not need to partition an array of two elements
		// And the number of swaps to return is 1
		if ((left + 1) == right){
			if(array[left] > array[right])
				swap(array, left, right);
			return 1;
		}
		
		int len = right - left + 1;
		int pivotIndex;
		switch (choice) {
		case LEFT:
			pivotIndex = left;
			break;
		case RIGHT:
			pivotIndex = right;
			break;
		case MEDIAN:
			int median = left + (right - left)/2;
			// As there are no repeated numbers we ignore equality tests
			if(array[left] < array[median] && array[median] < array[right])
				pivotIndex = median;
			else if(array[left] < array[right] && array[right] < array[median])
				pivotIndex = right;
			else 
				pivotIndex = left;
			break;
		default:
			throw new IllegalArgumentException("The pivot choice is not one of LEFT/RIGHT/MEDIAN");
		}
		
		int pivotFinalLocation = partition(array, left, right, pivotIndex);
		long leftSwaps = sort(array, left, pivotFinalLocation - 1, choice);
		long rightSwaps = sort(array, pivotFinalLocation + 1, right, choice);
		
		return (len - 1) + leftSwaps + rightSwaps;
	}
	
	public static long swap(int [] array, int choice) {
		return sort(array, 0, array.length - 1, choice);
	}
	
	private static void test() {

		int [] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(Arrays.toString(array));
		System.out.println("Swaps using left element as pivot = " + QuickSort.swap(array, QuickSort.LEFT));
		System.out.println("Swaps using right element as pivot = " + QuickSort.swap(array, QuickSort.RIGHT));
		System.out.println("Swaps using median element as pivot = " + QuickSort.swap(array, QuickSort.MEDIAN));
		
	}

	public static void main(String[] args) 
			throws NumberFormatException, FileNotFoundException {

		// QuickSort.test();
		
		
		int N = Integer.parseInt(args[0]);
		Scanner scanner = new Scanner (new File(args[1]));
		
		int [] array = new int[N];
		for(int i = 0; i < N; i++) {
			array[i] = scanner.nextInt();
		}

		System.out.println("Swaps using left element as pivot = " + QuickSort.swap(array, QuickSort.LEFT));
		System.out.println("Swaps using right element as pivot = " + QuickSort.swap(array, QuickSort.RIGHT));
		System.out.println("Swaps using median element as pivot = " + QuickSort.swap(array, QuickSort.MEDIAN));
		
	}

}
