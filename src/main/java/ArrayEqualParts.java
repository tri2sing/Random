import java.util.*;

public class ArrayEqualParts {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        for(int i = 0; i < T; i++){
            int N = stdin.nextInt();
            if (N == 1) {
            	int val = stdin.nextInt();
                System.out.println ("YES");
                continue;
            }
            int[] arr = new int[N];
            for(int j = 0; j < N; j++) arr[j] = stdin.nextInt();
            if(N == 2) {
                System.out.println ("NO");
                continue;
            }
            int left = arr[0];
            int right = 0;
            for (int j = 2; j < N; j++) right += arr[j];
            if(left == right) {
                System.out.println ("YES");
                continue;
            }
            else {
                for (int pivot = 2; pivot < N - 1; pivot++) {
                    left += arr[pivot - 1];
                    right -= arr[pivot];
                    if(left == right) {
                        System.out.println ("YES");
                        break;
                    }
                }
            }
            if (left != right) System.out.println("NO");
        }
    stdin.close();
    }
}
