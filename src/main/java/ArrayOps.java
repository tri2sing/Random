import java.util.Arrays;


public class ArrayOps {

	private static void swap(int [] array, int i, int j) {
		
		//System.out.format("swap: indices: %d and %d\n", i, j);
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * 
	 * @param array the numbers to partition them such that all numbers 
	 *        1) less than A[i] appear first
	 *        2) equal to A[i] appear next
	 *        3) greater than A[i] appear last 
	 * @param index the location of the value around which to partition
	 */
	public static void partitionArray(int [] array, int index) {

		int len = array.length;
		int track = 0; // The final location for the pivot
		
		int pivot = array[index];
		swap(array, index, len - 1);
		//System.out.println(Arrays.toString(array));
		for(int i = 0; i < len; i++){
			if(array[i] <= pivot) {
				swap(array, i, track);
				//System.out.println(Arrays.toString(array));
				track++;
			}
		}
		if(track < len)
			swap(array, track, len - 1);
	}
	
	private static void test() {
		int [] input1 = new int[] {1, 6, 2, 5, 3, 4, 3, 3, 3};
		System.out.println(Arrays.toString(input1));
		ArrayOps.partitionArray(input1, 4);
		System.out.println(Arrays.toString(input1));
		System.out.println();
		
		int [] input2 = new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		System.out.println(Arrays.toString(input2));
		ArrayOps.partitionArray(input2, 5);
		System.out.println(Arrays.toString(input2));
		System.out.println();
		
		int [] input3 = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		System.out.println(Arrays.toString(input3));
		ArrayOps.partitionArray(input3, 2);
		System.out.println(Arrays.toString(input3));
		System.out.println();
		
	}
	
	public static void main(String [] args) {
		ArrayOps.test();
	}
}
