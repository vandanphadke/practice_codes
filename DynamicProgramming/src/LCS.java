public class LCS {

	public static void main(String[] args) {
		
		count("ABCDEF", "ACEDFG");
	}
	
	public static void  count(String X, String Y)
	{
		int m = X.length();
		int n = Y.length();
	
		
		int[][] c = new int[m + 1][n + 1];
		char[][] dir = new char[m+1][n+1];
		
		for(int i = 0 ; i <= m ; i++)
		{	
			c[i][0] = 0 ;
			dir[i][0] = 'b';
		}
		for(int i = 0 ; i <= n ; i++){
			c[0][i] = 0 ;
			dir[0][i] = 'b';
		}
		for(int i = 1 ; i <= m ; i++)
		{
			for(int j = 1 ; j <= n ; j++)
			{
				if(X.charAt(i-1) == Y.charAt(j-1))
				{
					c[i][j] = 1 + c[i-1][j-1];
					dir[i][j] = 'd';
				}
				else if(c[i-1][j] >= c[i][j-1]) 
				{
					c[i][j] = c[i-1][j];
					dir[i][j] = 'u';
				}
				else{ 
					c[i][j] = c[i][j-1];
					dir[i][j] = 'l';
				}
			}
		}
		
		System.out.println(c[m][n]);
		printLCS(dir, m, n, X, Y);
	}
	
	public static void printLCS(char[][] dir, int i, int j, String X, String Y)
	{
		if(dir[i][j] == 'd')
		{
			printLCS(dir, i-1, j-1, X, Y);
			System.out.println(X.charAt(i - 1));
		}
		
		else if(dir[i][j] == 'l')
		{
			printLCS(dir, i, j-1, X, Y);
		}
		
		else if(dir[i][j] == 'u')
		{
			printLCS(dir, i-1, j, X, Y);
		}
		
		else 
			return ; 
		
	}
	
	
}
