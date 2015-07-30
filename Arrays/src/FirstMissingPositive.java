import java.util.Arrays;

/**
 * Q: Find the smallest positive number missing from an unsorted array
 * Must be done in O(n) time and constant space 
 * @author Vandan Phadke
 *
 */
public class FirstMissingPositive {
	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
	}
	
	public static int firstMissingPositive(int[] A) {  
		   // in-place swap (bucket sort)  
		   int i = 0;  
		   while (i < A.length) {  
		     if (A[i] > 0 && A[i] <= A.length && A[i] != i+1 && A[i] != A[A[i]-1]) {
		       System.out.println("Swap" + i + "and " + (A[i] - 1)) ;
		       int temp = A[A[i]-1];  
		       A[A[i]-1] = A[i];  
		       A[i] = temp;  
		     } else {  
		       ++i;  
		     }  
		   }   
		   System.out.println(Arrays.toString(A));
		   i = 0;  
		   while (i < A.length && A[i] == i+1) ++i;  
		   return i+1;  
		 } 
}
