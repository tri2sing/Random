import java.util.*;

public class PickCards {

	public static final long MOD = 1000000007;
	
    public static long picks(int [] arr, int N) {
        long res = 1;
        Arrays.sort(arr);
        int [] local = new int[N - 1];
        for (int i = 0; i < N - 1; i++) local[i] = 1;
        
        return res;
    }
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
            int [] arr = new int [N];
            for (int j = 0; j < N; j++) 
                arr[i] = in.nextInt ();
		    System.out.println(PickCards.picks(arr, N));
        }
		in.close();
	}

}
