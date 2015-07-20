import java.util.Arrays;

/**
 * Q: Given a number n, find the smallest number that has same set of digits as n 
 * and is greater than n. If x is the greatest possible number with its set of digits, 
 * then print “not possible”.
 * @author Vandan Phadke
 *
 */
public class NextGreatestNumber {
	public static void main(String[] args) {
		int n = 534976;
		getNextNumber(n);
	}
	
	public static void getNextNumber(int num){
		int[] arr = Integer.toString(num).chars().map(c -> c-='0').toArray();
		int n = arr.length - 1 ; 
		int i; 
		for(i = n-1 ; i >=0 ; i--){
			if(arr[i] > arr[i-1])
				break; 
		}
		
		if(i == 0){
			System.out.println("Not possible");
		}
		else{
			// Find the smallest digit on right side of (i-1)'th digit that is
		    // greater than number[i-1]
		    int x = arr[i-1], smallest = i;
		    
		    for (int j = i+1; j <= n; j++)
		        if (arr[j] > x && arr[j] < arr[smallest])
		            smallest = j;
			
		    int temp = arr[i-1];
		    arr[i-1] = arr[smallest];
		    arr[smallest] = temp ; 
		    Arrays.sort(arr, i, n + 1);
		    System.out.println(Arrays.toString(arr));
		}
	} 
}
