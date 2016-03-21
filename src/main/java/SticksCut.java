import java.util.*;

/**
 * 
 * @author Sameer Adhikari
 * Input: Unsorted array of integers
 * Operation: In each round reduce the value of all integers by the minimum non-zero value
 * Output: Number of values that can be reduced in each round till all values are zero
 * Key: To reduce search for minimum element, sort the list ascending before starting cuts
 *
 */
public class SticksCut {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int N = in.nextInt();
		int [] array = new int [N];
		for(int i = 0; i < N; i++)
			array[i] = in.nextInt();
		Arrays.sort(array);
		int start = 0;
		while (start < N) {
			int size = array[start];
			int cuts = 0;
			for (int j = start; j < N; j++) {
				array[j] -= size;
				cuts++;
				if(array[j] == 0) start++;
			}
			System.out.println(cuts);
		}
	in.close();
	}

}
