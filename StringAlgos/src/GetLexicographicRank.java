/**
 * Q: Lexicographic rank of a string
      Given a string, find its rank among all its permutations sorted lexicographically. 
      For example, rank of “abc” is 1, rank of “acb” is 2, and rank of “cba” is 6.
 * @author Vandan Phadke
 * Currently this algo is not handling repeating characters
 *
 */
public class GetLexicographicRank {
	public static void main(String[] args) {
		String s = "STRING";
		System.out.println(getLexicographicRank(s));
	}
	
	public static int getLexicographicRank(String s){
		int len = s.length();
		int rank = 1 ;
		int mul = getFactorial(len);
		int countRight = 0 ; 
		for(int i = 0 ; i < len ; i++){
			mul  /= (len - i);
			countRight = countSmallerIn(s, i);
			
			rank += (countRight * mul); 
		}
		
		return rank; 
	}
	
	public static int getFactorial(int n){
		int[] arr = new int[n+1];
		arr[0] = 1 ; 
		arr[1] = 1 ; 
		for(int i = 2 ; i <= n ; i++){
			arr[i] = i * (arr[i-1]);
		}
		return arr[n]; 
	}
	
	public static int countSmallerIn(String s, int low){
		
		int countRight = 0;
		for(int i = low + 1 ; i < s.length() ; ++i){
			if(s.charAt(i) < s.charAt(low))
				++countRight;
		}
		return countRight;
	}
}
