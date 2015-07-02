
public class RegExMatching {
	public static void main(String[] args) {
		String a = "aaaabbbccdd";
		String b = "aaaabbbccdd";
		System.out.println(match(a, b));
	}
	
	public static boolean match(String s, String m){
		return match(s.toCharArray(), m.toCharArray(), 0, 0);
	}
	
	public static boolean match(char[] s, char[] m, int i, int j){
		
		return true;
	}
}
