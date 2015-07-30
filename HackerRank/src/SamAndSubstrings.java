import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/sam-and-substrings
 * @author Vandan Phadke
 *
 */
public class SamAndSubstrings {
	public static final long MOD = 1000000007;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
        int no = s.length() ;
        int[] arr = new int[no];
        for(int i = 0 ; i < no ; i++)
        	arr[i] = s.charAt(i) - '0';
        
        System.out.println(getSumofSubstrings(arr, no));

	}
	
	public static long getSumofSubstrings(int[] number, int n){
		long outp = number[0];
		long temp = number[0];
		for(int i = 1 ; i < n ; i++){
			temp = (10*temp) + (i+1)*(number[i]);
			temp = temp % MOD;
			outp = (outp + temp) % MOD;
		}
		return outp ;
	}
}
