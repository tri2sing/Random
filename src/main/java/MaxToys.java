import java.util.*;

public class MaxToys {

    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt(),k=stdin.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++) prices[i]=stdin.nextInt();
        
        // Compute the final answer from n,k,prices 
        int answer = 0;
        Arrays.sort(prices);
        int current = 0;
        while(prices[current] <= k) {
        	k -= prices[current++];
        	answer++;
        }
        System.out.println(answer);
        stdin.close();
    }

}
