package Stack;

import java.util.Stack;

/**
 * Q: http://www.geeksforgeeks.org/the-stock-span-problem/
 * @author Vandan Phadke
 *
 */
public class StockSpan {
	public static void main(String[] args) {
		int[] arr = {10, 4, 5, 90, 120, 80};
		calculateSpan(arr);
	}
	
	public static void calculateSpan(int[] arr){
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		
		for(int i = 0 ; i < arr.length ; i++){
			int span = 1 ;
			while(!s.isEmpty() && arr[s.peek()] < arr[i])
				s.pop();
			
			if(s.isEmpty())
				System.out.println(arr[i] + " span is " + (i+1));
			else
				System.out.println(arr[i] + " span is " + (i - s.peek()));
			
			s.push(i);
		}
	}
}
