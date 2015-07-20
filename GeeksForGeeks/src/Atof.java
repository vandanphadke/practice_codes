
public class Atof {
	public static void main(String[] args) {
		String s = "+23.56";
		double d = atof(s);
		System.out.println(d);
	}
	
	public static double atof(String n){
		
		boolean sign = n.charAt(0) == '-' ? false:true ; 
		
		int i = 1 ;
		int l = 0, r = 0; 
		while(n.charAt(i) != '.'){
			l = l*10 + (n.charAt(i) - '0');
			++i;
		}
		++i;
		int digit = 0 ;
		while(i < n.length()){
			r = r*10 + (n.charAt(i) - '0');
			++i;++digit; 
		}
		
		double a = l + (r / Math.pow(10, digit));
		return a; 
	}
}
