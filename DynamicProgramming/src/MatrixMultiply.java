
public class MatrixMultiply {
	public static void main(String[] args) {
		
	}
	
	public static int matrixChain(int[] p)
	{
		int n = p.length - 1 ; 
		int[][] m = new int[n][n];
		for(int i = 0 ; i < n ; i++)
			for(int j = 0; j < n; j++)
				m[i][j] = Integer.MAX_VALUE ; 
		return lookupChain(m, p, 0, n-1);
	}
	
	public static int lookupChain(int[][] m, int[] p , int i, int j)
	{
		if(m[i][j] < Integer.MAX_VALUE)
			return m[i][j];
		
		if(i == j)
			m[i][j] = 0 ;
		
		return 0 ; 
	}
}
