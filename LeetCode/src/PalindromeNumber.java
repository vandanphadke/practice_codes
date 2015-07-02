
public class PalindromeNumber {
	public static void main(String[] args) {
		int x = 1234;
		System.out.println(checkIfPalindrome(x));
	}
	
	public static boolean checkIfPalindrome(int no){
		if(no < 0) return false;
		if(no / 10 == 0) return true; 
		int n = no, digits = 0 ; 
		while(n != 0){
			++digits;
			n = n / 10 ;
		}
		n = no; 
		int d = digits;
		while(n != 0){
			int a = n % 10 ;
			int b = (int) (n / (Math.pow(10, d - 1)));
			if(a != b)
				return false;
			
			n = n / 10 ;
			d = d - 1 ; 
			n = (int) (n % (Math.pow(10, d - 1))); 
			d = d - 1 ;
		}
		return true;
	}
}
