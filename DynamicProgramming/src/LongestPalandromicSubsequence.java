
public class LongestPalandromicSubsequence {
	public static void main(String[] args) {
		System.out.println(lps("GEEKS FOR GEEKS".toLowerCase()));
	}
	
	public static int lps(String s){
		int n = s.length();
		int i, j, cl;
		int[][] L = new int[n][n];
		 
		for (i = 0; i < n; i++)
			L[i][i] = 1;
		 
		    // Build the table. Note that the lower diagonal values of table are
		    // useless and not filled in the process. The values are filled in a
		    // manner similar to Matrix Chain Multiplication DP solution (See
		    // http://www.geeksforgeeks.org/archives/15553). cl is length of
		    // substring
		    for (cl=2; cl<=n; cl++)
		    {
		        for (i=0; i<n-cl+1; i++)
		        {
		            j = i+cl-1;
		            if (s.charAt(i) == s.charAt(j) && cl == 2)
		               L[i][j] = 2;
		            else if (s.charAt(i) == s.charAt(j))
		               L[i][j] = L[i+1][j-1] + 2;
		            else
		               L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
		        }
		    }
		 
		    return L[0][n-1];
	}
}
