
public class DoubleToBinary {
	public static void main(String[] args) {
		System.out.println(toBinary(0.6));
	}
	
	public static String toBinary(double d){
		double num = d ; 
		if(num <= 0 || num >= 1)
			return "ERROR";
		
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		
		while(num > 0){
			if(sb.length() >= 32)
				return "ERROR";
			
			double temp = num * 2 ;
			
			if(Double.compare(num, 1.0) < 0){
				sb.append("1");
				num = temp - 1 ;
			}
			else{
				sb.append("0");
				num = temp ;
			}
		}
		
		return sb.toString();
	}
}
