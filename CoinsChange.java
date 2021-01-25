import java.util.Scanner;
import java.util.ArrayList;
class CoinsChange
{
	static int coinsChange(ArrayList<Integer> coins, int amt)
	{
		int n = coins.size();
		int[][] t = new int[n+1][amt+1];
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=amt; j++)
			{
				if(j==0)
					t[i][j] = 0;
				else if (i==0) 
					t[i][j] = 100000;
				else if(coins.get(i-1)>j)
					t[i][j] = t[i-1][j];
				else 
					t[i][j] = Math.min(1+t[i][j-coins.get(i-1)] , t[i-1][j]);
			}
		}
		return t[n][amt]>10000? -1 : t[n][amt];
	}

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> alist = new ArrayList<>();
        for (int i=0;i<n;i++)               	
            alist.add(sc.nextInt());
        int amt = sc.nextInt();
        System.out.print(coinsChange(alist,amt));
    }
}