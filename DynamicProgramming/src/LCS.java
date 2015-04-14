public class LCS {

	public static void main(String[] args) {
		
		System.out.println(count("ABCBDABDABCD", "BDCABADACB"));
	}
	
	public static int count(String X, String Y)
	{
		int m = X.length();
		int n = Y.length();
		
		System.out.println(m + "   " + n);
		
		int[][] c = new int[m + 1][n + 1];
		
		for(int i = 0 ; i <= m ; i++)
			c[i][0] = 0 ; 
		for(int i = 0 ; i <= n ; i++)
			c[0][i] = 0 ;
		
		for(int i = 1 ; i <= m ; i++)
		{
			for(int j = 1 ; j <= n ; j++)
			{
				if(X.charAt(i-1) == Y.charAt(j-1))
				{
					c[i][j] = 1 + c[i-1][j-1];
				}
				else if(c[i-1][j] >= c[i][j-1]) 
				{
					c[i][j] = c[i-1][j];
				}
				else 
					c[i][j] = c[i][j-1];
			}
		}
		
		for(int i = 0 ; i < m+1 ; i++)
		{
			for(int j = 0 ; j < n+1 ; j++)
			{
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		return c[m][n]; 
	}
}
