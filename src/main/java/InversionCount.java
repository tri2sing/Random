import java.io.*;
import java.util.*;

public class InversionCount {

	private int [] array;
	private int [] helper;
	private int N;
	
	public InversionCount(int [] array) {
		this.N = array.length;
		this.array = array;
		helper = new int[N];
	}
	
	public long count() {
		return mergesort(0, this.N - 1);
	}
	
	private long mergesort(int low, int high) {
		long inversions = 0;

		if (low >= high) return inversions; 

		int middle = low + (high - low) / 2;
		long left = mergesort(low, middle);
		long right = mergesort(middle + 1, high);
		long split = merge(low, middle, high);
		inversions = left + right + split;
		
		return inversions;
	}
	/**
	 * 
	 * @param low the beginning of the left sub-array
	 * @param middle the end of the left sub-array
	 * @param high the end of the right sub-array which begins are middle + 1
	 * @return the number of inversions in the array
	 */
	private long merge(int low, int middle, int high) {
		long inversions = 0;
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while(i <= middle && j <= high) {
			if(helper[i] <= helper[j]) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
				inversions += (middle - i + 1);
			}
			k++;
		}
		// Copy remaining part of the left side into the target array
		while(i <= middle) {
			array[k] = helper[i];
			i++;
			k++;
		}
		// We don't need to copy the remaining part of the right side to the target array
		return inversions;
	}
	
	public static void main(String[] args) 
			throws NumberFormatException, FileNotFoundException {

		int N = Integer.parseInt(args[0]);
		Scanner scanner = new Scanner (new File(args[1]));
		
		int [] array = new int[N];
		for(int i = 0; i < N; i++) {
			array[i] = scanner.nextInt();
		}
		
		InversionCount ic = new InversionCount(array);
		System.out.println(ic.count());

	scanner.close();
	}

}
