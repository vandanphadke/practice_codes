import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * Q: Find the next palindrome for a given integer
 * @author Vandan Phadke
 *
 */
public class NxtPalindrome {
	public static void main(String[] args) {
		int[] x = new int[]{5,4,3,2,3,4,5};
		int i = 0 , j = 0 ; 
		int n = x.length;
		boolean middle = true;
		if(n %2 == 0){
			i = n / 2 ;
			j = (n/2) + 1 ;
			middle = false;
		}
		else{
			i = (n/2) - 1;
			j = (n/2) + 1;
		}
		
		while(i >= 0 &&  j <= n - 1 && x[i] == x[j]){
			i--; j++;
		}
		
		if(i == -1 && j == n){
			
		}
		
		if(x[i] > x[j]){
			for(int i1 = 0 ; i1 <= i ; i1 ++){
				x[n - 1 - i1] = x[i1];
			}
		}
	}
}