import java.util.*;

public class AnagramDeletions {

	/**
	 * @param args
	 */
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String s1 = in.next();
        String s2 = in.next();
        char [] a1 = s1.toCharArray();
        char [] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        int deletions = 0;
        int instances = 1;
        System.out.println(deletions);
    }
}
