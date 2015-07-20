package Arrays;

import java.util.Stack;

/**
 * Q: Given an array of integers, find the nearest smaller number 
 * for every element such that the smaller element is on left side.
 * @author Vandan Phadke
 *
 */
public class NearestSmallestNumber {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 6, 4, 10, 2, 5}; 
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0 ; i < arr.length ; i++){
			while(!s.isEmpty() && s.peek() >= arr[i])
				s.pop();
			
			if(s.isEmpty())
				System.out.print("-1" + " ");
			else
				System.out.print(s.peek() + " ");
			s.push(arr[i]);
		}
	}
}
