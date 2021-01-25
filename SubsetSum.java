import java.util.Arrays;
import java.util.Scanner; 
public class SubsetSum
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        	arr[i] = sc.nextInt();
        int sum = sc.nextInt();
        System.out.print(subsetSum(arr,sum, n));
    }
	
    /* This Problem is a variation on 0-1 Knapsack */

      
	static boolean subsetSum(int[] arr, int sum, int n)
	{
		boolean[][] t = new boolean[n+1][sum+1];

		for(int i=0; i<=n; i++)
			for (int j=0; j<=sum; j++)
            {
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }		


		for(int i=1; i<=n; i++)
			for (int j=1; j<=sum; j++)
			{
				if(arr[i-1]<=j)
					t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
				else
					t[i][j] = t[i-1][j];
			}	
		return t[n][sum];		
	}
}
