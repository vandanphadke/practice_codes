package Basic;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3};
		int n = 10;
		System.out.println(count(arr,n));
	}
	
	public static int count( int[] S, int n )
	{
	    int i, j, x, y;
	 
	    // We need n+1 rows as the table is constructed in bottom up manner using 
	    // the base case 0 value case (n = 0)
	    int[][] table = new int[n+1][S.length];
	    
	    // Fill the entries for 0 value case (n = 0)
	    for (i=0; i<S.length; i++)
	        table[0][i] = 1;
	 
	    // Fill rest of the table entries in bottom up manner  
	    for (i = 1; i < n+1; i++)
	    {
	        for (j = 0; j < S.length; j++)
	        {
	            // Count of solutions including S[j]
	            x = (i-S[j] >= 0)? table[i - S[j]][j]: 0;
	 
	            // Count of solutions excluding S[j]
	            y = (j >= 1)? table[i][j-1]: 0;
	 
	            // total count
	            table[i][j] = x + y;
	        }
	    }
	    for(int i1 = 0 ; i1 < n ; i1++)
	    {	
	    	for(int j1 = 0; j1 < S.length ; j1++ )
	    		System.out.print(table[i1][j1] + " ");
	    	System.out.println();
	    }
	    return table[n][S.length-1];
	}

}
