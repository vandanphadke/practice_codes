
public class TilingProblems {

	public static void main(String[] args) {
		System.out.println(lTiles(4));
	}
	
	public static int simpleTiles(int n)
	{
		int[] ways = new int[n + 1];
		ways[0] = 1 ; 
		ways[1] = 1 ; 
		
		for(int i = 2 ; i <= n ; i++)
			ways[i] = ways[i-1] + ways[i-2];
		
		return ways[n];
	}
	
	public static int lTiles(int n)
	{
		int[] f = new int[n+1];
		int[] g = new int[n+1];
		f[0] = 1 ; f[1] = 1 ; 
		g[0] = 1 ; g[1] = 1 ; 
		
		for(int i = 2 ; i <= n ; i++)
		{
			f[i] = f[i-1] + f[i-2] + 2*g[n-2];
			g[i] = f[i-1] + g[i-1];
		}
		
		return f[n];
	}
}
