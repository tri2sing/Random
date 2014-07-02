import java.util.*;

public class FullCountSort {

	public static void main(String[] args) {
        int range = 100;
        int[] counts = new int[range];
        for(int i = 0; i < range; i++) counts[i] = 0;
        
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        
        // Map a string to it location in the input stream so that we can handle the twist
        HashMap<String, Boolean> hmInputOrder = new HashMap<String, Boolean>();
        
        // Map an integer to a list of strings that are associated with it
        HashMap<Integer, LinkedList<String>> hmIntList = new HashMap<Integer, LinkedList<String>>();
        
        for (int i = 0; i < nums; i++) {
            int ival = in.nextInt();
            String sval = in.next();
            // Track how many values we have seen for a given integer
            counts[ival]++;
            // Track if the string occurs in the second half of the input stream
            if (i >= nums/2)
                hmInputOrder.put(sval, Boolean.TRUE);
            else 
                hmInputOrder.put(sval, Boolean.FALSE);

 
            LinkedList<String> l = hmIntList.get(ival);
            if (l == null) {
                l = new LinkedList<String>();
            } 
            l.add(sval);
            hmIntList.put(ival, l);
        }
        
        for (int i = 0; i < range; i++) {
            if (counts[i] > 0) {
                for (String s: hmIntList.get(i)) {
                    if (hmInputOrder.get(s) == Boolean.TRUE)
                        System.out.print(s + " ");
                    else
                        System.out.print("- ");
                }
            }
        }
        System.out.println();
        in.close();
    }

}
