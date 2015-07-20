/**
 * Q: Given three strings A, B and C. Write a function that checks whether C is an interleaving 
 * of A and B. C is said to be interleaving A and B, if it contains all characters 
 * of A and B and order of all characters in individual strings is preserved.
 * @author Vandan Phadke
 *
 */
public class StringInterleaving {
	public static void main(String[] args) {
		String A = "XXY";
		String B = "XXZ";
		String C = "XXZXXY";
		
		System.out.println(findInterleaving(A, B, C));
	}
	
	public static boolean findInterleaving(String a, String b, String c){
		
		int m = a.length();
		int n = b.length();
		
		if(m + n != c.length())
			return false; 
		
		boolean tab[][] = new boolean[m+1][n+1];
		
		for(int i = 0 ; i <= m ; i++){
			for(int j = 0 ; j <= n ; j++){
				if(i == 0 && j == 0)
					tab[i][j] = true ;
				
				else if(i == 0 && b.charAt(j-1) == c.charAt(j-1))
					tab[i][j] = tab[i][j-1];
				
				else if(j == 0 && a.charAt(i-1) == c.charAt(i-1))
					tab[i][j] = tab[i-1][j];
				
				else if(c.charAt(i + j - 1) == a.charAt(i - 1) && b.charAt(j-1) != c.charAt(i + j - 1))
					tab[i][j] = tab[i-1][j];
				
				else if(c.charAt(i + j - 1) != a.charAt(i - 1) && b.charAt(j-1) == c.charAt(i + j - 1))
					tab[i][j] = tab[i][j-1];
				
				else if(c.charAt(i + j - 1) == a.charAt(i - 1) && b.charAt(j-1) == c.charAt(i + j - 1))
					tab[i][j] = (tab[i-1][j] || tab[i][j-1]);
			}
		}
		
		return tab[m][n]; 
	}
}
