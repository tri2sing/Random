
public class QuickSort {

	public static final int LEFT = -1;
	public static final int RIGHT = -1;
	public static final int MIDDLE = 0;


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
	 * @param choice LEFT, RIGHT, or MIDDLE value of the array to use as pivot
	 * @return the number of swaps performed by quick sort algorithm
	 */
	private static long partition (int [] array, int left, int right, int choice) {
		
		// An array of length 1 is already sorted,
		// and we do not need to perform any swaps
		if(left == right) {
			return 0;
		}
		
		// The number of swaps is one less than the length of the array
		long swaps = right - left;
		
		return swaps;
	}
	
	/**
	 * 
	 * @param array the integer values to be sort
	 * @param choice LEFT, RIGHT, or MIDDLE value of the array to use as pivot
	 * @return the number of swaps performed by quick sort algorithm
	 */
	
	public static long sort(int [] array, int choice) {
		long swaps = 0;
		
		return swaps;
	}
	
	public static void main(String[] args) {

	}

}
