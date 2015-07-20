/**
 * Q: A message containing letters from A-Z is being encoded to numbers using the following mapping:

	 'A' -> 1
	 'B' -> 2
	 'Z' -> 26
	  Given an encoded message containing digits, determine the total number of ways to decode it.
	
	  For example,
	  Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

	  The number of ways decoding "12" is 2.
 * @author Vandan Phadke
 *
 */
public class WaysDecoding {
	public int numDecodings(String s) {     
        if(s.isEmpty()||s.charAt(0)=='0') return 0;
        int[] counts=new int[s.length()+1];
        counts[0]=1;
        counts[1]=1;
        for(int i=1;i<s.length();i++){                                      //counts[i+1] stores the count for s.charAt(i)
            int digit2 = Integer.parseInt(s.substring(i-1,i+1));            //validating the integer represented by this and the last digits
            if(digit2==0) return 0;
            if(digit2<=26&&digit2>=10&&(i==s.length()-1||s.charAt(i+1)!='0')) counts[i+1]+=counts[i-1];
            if(s.charAt(i)!='0') counts[i+1]+=counts[i];                    //validating current digit
        }
        return counts[s.length()];
    }
}
