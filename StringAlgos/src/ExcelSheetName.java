/**
 * Q: MS Excel columns has a pattern like A, B, C, … ,Z, AA, AB, AC,…. ,AZ, BA, BB, … ZZ, AAA, AAB ….. etc. 
 * 	  In other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA”.
	
	  Given a column number, find its corresponding Excel column name
 * @author Vandan Phadke
 *
 */
public class ExcelSheetName {
	public static void main(String[] args) {
		int column_number = 51; 
		System.out.println(findColumnName(column_number));
	}
	
	public static String findColumnName(int column){
		StringBuffer sb = new StringBuffer();
		int n = column;
		
		while(n > 0){
			int rem = n % 26;
			
			if(rem == 0){
				sb.append('Z');
				n = (n / 26) - 1 ;
			}
			else{
				sb.append((char)((rem - 1) + 'A'));
				n = n / 26;
			}
		}
		return sb.reverse().toString() ; 
	}
}