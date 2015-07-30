package linkedin;

import java.math.MathContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Q: Add the Numbers present in the String and display.
      E.g. “abc123def-567ghi89jk”
      Here take ‘-‘ as negative number symbol.
 * @author Vandan Phadke
 *
 */
public class SumofNumbersFromAString {
	public static void main(String[] args) {
		String s = "abc123def-567ghi89jk";
		System.out.println(getSumofIntegers(s));
	}
	
	public static int getSumofIntegers(String s){
		int sum = 0 ; 
		Pattern pattern = Pattern.compile("-?[0-9]+");
		Matcher matcher = pattern.matcher(s);
		
		while(matcher.find()){
			int i = Integer.parseInt(s.substring(matcher.start(), matcher.end()));
			sum += i ; 
		}
		
		return sum ; 
	}
}
