import java.util.*;

/*
	Input Format
	There will be four lines of input:
	
	n - the size of the first list (from which numbers are missing)
	This is followed by n space-separated integers that make up the first list.
	m - the size of the second list
	This is followed by m space-separated integers that make up the second list.
	
	Output Format
	Output the missing numbers in ascending order.
	
	Constraints
	1≤n,m≤1000010
	1≤x≤10000,x∈B
	Xmax−Xmin<101
 */

public class ListComparison {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			Integer key = new Integer(in.nextInt());
			Integer value = tm.get(key);
			if (value == null) {
				tm.put(key, new Integer(1));
			}
			else {
				tm.put(key, new Integer(value.intValue() + 1));
			}
		}
		int M = in.nextInt();
		for (int i = 0; i < M; i++) {
			Integer key = new Integer(in.nextInt());
			Integer value = tm.get(key);
			if (value == null) {
				tm.put(key, new Integer(-1));
			}
			else {
				tm.put(key, new Integer(value.intValue() - 1));
			}
		}
		for(Map.Entry<Integer, Integer> entry: tm.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			if (value.intValue() < 0) {
				System.out.print(key.intValue() + " ");
			}
		}
		
	}
}
