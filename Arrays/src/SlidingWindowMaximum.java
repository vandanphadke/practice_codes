import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Q: Given an array and an integer k, find the maximum for each and every 
 * contiguous subarray of size k in linear time
 * @author Vandan Phadke
 *
 */
public class SlidingWindowMaximum {
	public static void main(String[] args) {
		int[] arr = {1,2,3,1,4,5,2,3,6};
		int k = 3 ; 
		//System.out.println(Arrays.toString(slidingWindowMaximum(arr, k)));
		int a = 3, b = 5 ; 
		a =  a + b ; 
		b = a - b ; 
		a = a - b ;
		System.out.println(a + "  " + b);
	}
	
	public static int[] slidingWindowMaximum(int[] arr, int k){
		int[] ans = new int[arr.length-k+1];
		int a = 0 ; 
		Deque<Integer> dequeue = new LinkedList<Integer>();
		int i = 0 ; 
		for(i = 0 ; i < k; i++){
			while(!dequeue.isEmpty() && arr[i] >= arr[dequeue.peekLast()])
				dequeue.removeLast();
			
			dequeue.addLast(i);
		}
		for(; i < arr.length ; i++){
			ans[a++] = arr[dequeue.peekFirst()];
			while (!dequeue.isEmpty() && dequeue.peek() < i - k + 1) {
                dequeue.poll();
            }
			while(!dequeue.isEmpty() && arr[i] >= arr[dequeue.peekLast()])
				dequeue.removeLast();
			
			dequeue.addLast(i);
		}
		
		return ans; 
	}
}
