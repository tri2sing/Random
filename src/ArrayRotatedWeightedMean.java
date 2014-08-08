import java.util.*;

public class ArrayRotatedWeightedMean {
	public static void main(String[] ags) {
		Scanner stdin = new Scanner(System.in);
		int N = stdin.nextInt();
		long[] arr = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = stdin.nextLong();

		long sum = 0, weighted = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			weighted += (i + 1) * arr[i];
		}
		
		long max = weighted;
		
		for(int i = 1; i < N; i ++) {
			weighted -= sum;
			weighted += arr[i - 1]*N;
			if(weighted > max) max = weighted;
		}
		System.out.println(max);
		stdin.close();
	}

}
