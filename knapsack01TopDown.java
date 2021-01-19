import java.util.Arrays;
import java.util.Scanner; 
public class knapsack01TopDown
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
        System.out.print(knapsackTopDown(wt, val, cap, n));
    }
	

	//  Recursion
//     static int knapsackRec(int[] w, int[] v, int W, int n) {
//     if (n <= 0) { 
//         return 0; 
//     } else if (w[n - 1] > W) {
//         return knapsackRec(w, v, W, n - 1);
//     } else {
//         return Math.max(knapsackRec(w, v, W ,n - 1), v[n - 1] 
//           + knapsackRec(w, v,  W - w[n - 1]), n - 1);
//     }
// }


    /* Recursion change into To down iterative solution 
    	1. First create a matrix of size n+1, w+1
    	2. Now initialize it's 1st row and colums with zero -> take 2 loop and t[i][j]=0
    	3. Now the help of recursive solution change recursive call with matrix call 
    		as if (w[n - 1] > W)
    			return knapsackRec(w, v, W, n - 1)
    		it will be change as 
    		if (wt[n-1] > W)
    			t[n][w] = t[n-1][w]
    	4. similarly change the all fuction call
    	5. Now replave evert n and w with i and j and put all the code in 2 for loop.

    */

    
	static int knapsackTopDown(int[] wt, int[] val, int w, int n)
	{
		int[][] t = new int[n+1][w+1];		
		for(int i=0; i<t.length; i++)
			for (int j=0; j<t[0].length; j++)
				if(i==0 || j==0)
					t[i][j] = 0;

		for(int i=1; i<t.length; i++)
			for (int j=1; j<t[0].length; j++)
			{
				if(wt[i-1]<=j)
					t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]);
				else
					t[i][j] = t[i-1][j];
			}	
		return t[n][w];		
	}
}