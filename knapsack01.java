import java.util.Arrays;
import java.util.Scanner; 
public class knapsack01
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for(int i=0; i<n; i++)
        	wt[i] = sc.nextInt();
        for(int i=0; i<n; i++)
        	val[i] = sc.nextInt();
        int cap = sc.nextInt();
        // System.out.print(knapsackRec(wt, val, n, cap));
        System.out.print(knapsack(wt, val, cap, n));
    }
	

    // Recursion
//     static int knapsackRec(int[] w, int[] v, int n, int W) {
//     if (n <= 0) { 
//         return 0; 
//     } else if (w[n - 1] > W) {
//         return knapsackRec(w, v, n - 1, W);
//     } else {
//         return Math.max(knapsackRec(w, v, n - 1, W), v[n - 1] 
//           + knapsackRec(w, v, n - 1, W - w[n - 1]));
//     }
// }


    // Recursion + memoization As of now not working


    // static 
	static int knapsack(int[] wt, int[] val, int w, int n)
	{
		int[][] t = new int[102][1002];		
		for(int[] row : t) 
		    Arrays.fill(row, -1);

		if(n==0 || w==0)
			return 0;
		if(t[n][w]!=-1)
			return t[n][w];
		if(wt[n-1]<=w)
			return t[n][w]=Math.max(val[n-1]+knapsack(wt, val, w-wt[n-1], n-1),
				knapsack(wt, val, w, n-1));
		else if(wt[n-1]>w)
			return t[n][w]=knapsack(wt, val, w, n-1);
		return -1;
	}
}