public class RestoreIPAddresses {
	public static void main(String[] args) {
		
	}
	
	public static boolean isValid(String num){
		if(num == null || num.length() > 3)
			return false;
		
		if(num.length() > 0 && num.charAt(0) == '0')
			return false;
		
		if(num.length() > 0 && Integer.parseInt(num) > 255)
			return false;
		
		return true;
	}
	
}
