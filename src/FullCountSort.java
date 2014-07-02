import java.util.*;

public class FullCountSort {

	public static void main(String[] args) {
		int range = 100;
		int[] counts = new int[range];
		for (int i = 0; i < range; i++)
			counts[i] = 0;

		Scanner in = new Scanner(System.in);
		int nums = in.nextInt();

		// Map an integer to a list of strings that are associated with it
		HashMap<Integer, ArrayList<String>> hms = new HashMap<Integer, ArrayList<String>>();
		for (int i = 0; i < range; i++) hms.put(i, new ArrayList<String>());
		
		// Map an integer to the position of associated strings in stream.
		// There is a 1-1 correspondence between this map and the previous
		// one in terms of the index of entries in a list.
		HashMap<Integer, ArrayList<Boolean>> hmb = new HashMap<Integer, ArrayList<Boolean>>();
		for (int i = 0; i < range; i++) hmb.put(i, new ArrayList<Boolean>());

		ArrayList<String> l;
		ArrayList<Boolean> b;
		for (int i = 0; i < nums; i++) {
			int ival = in.nextInt();
			String sval = in.next();
			//System.out.println("Read " + ival + ", " + sval);
			counts[ival]++;

			l = hms.get(ival);
			l.add(sval);
			hms.put(ival, l);

			b = hmb.get(ival);
			if (i >= nums/2) b.add(true);
			else b.add(false);
			hmb.put(ival, b);
}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < range; i++) {
			if (counts[i] > 0) {
				l = hms.get(i);
				b = hmb.get(i);
				for (int j = 0; j < l.size(); j++) {
					if (b.get(j)) sb.append(l.get(j));
					else sb.append("-");
					sb.append(" ");
				}
			}
		}
		System.out.print(sb);
		in.close();
	}

}
