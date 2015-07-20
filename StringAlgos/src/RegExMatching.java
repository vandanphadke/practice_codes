
public class RegExMatching {
	public static void main(String[] args) {
		System.out.println(match("g*ks", "geeks"));
		System.out.println(match("ge?ks", "geeksforgeeks"));
		System.out.println(match("g*k", "gee"));
	}
	
	public static boolean match(String a, String b){
		return match(a.toCharArray(), b.toCharArray(), 0 , 0);
	}
	public static boolean match(char[] first, char[] second, int i, int j){
		//System.out.println(first[i] + "   " + second[j]);
		if(i == first.length - 1 && j == second.length - 1)
			return true; 
		
		if(first[i] == '*' && i + 1 != first.length - 1 &&  j == second.length - 1 )
			return false; 
		
		if(first[i] == '?' || first[i] == second[j])
			return match(first, second, i + 1 , j + 1);
		
		
		if(first[i] == '*')
			return match(first, second, i + 1, j) || match(first, second, i, j+1);
		return false; 
	}
}
