import java.util.HashMap;


public class AddTwoBinary {
	public static void main(String[] args) {
		String a = "101010";
		String b = "010101";
		System.out.println(addBinary(a, b));
	}
	
	public static String addBinary(String a, String b){
		StringBuilder sb = new StringBuilder(Math.max(a.length(), b.length()) + 1);
		int carry = 0 , sum = 0 ; 
		int i = a.length() - 1, j = b.length() - 1 ; 
		for( ; i >=0 || j>= 0 ; i--, j--){
			sum = (i > 0 ? a.charAt(i) - '0' : 0) + (j > 0 ? b.charAt(i) - '0' : 0) + carry;
			if(sum >= 2){
				sb.insert(0, sum - 2);
				carry = 1 ;
			}
			else{
				sb.insert(0, sum);
				carry = 0 ;
			}
			if(carry != 0) sb.insert(0, 1);
		}
		return sb.toString();
	}
}
