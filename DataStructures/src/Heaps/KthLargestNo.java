package Heaps;

import java.util.PriorityQueue;

/**
 * Q: Given an infinite stream of integers, find the kth largest element at any point
 * of time.
 * @author Vandan Phadke
 * 
 */
public class KthLargestNo {
	public static void main(String[] args) {
		int[] arr = {10, 20, 11, 70, 50, 40, 100, 5};
		int k = 3 ;
		getKthLargestfromStream(arr, k);
	}
	
	public static void getKthLargestfromStream(int[] arr, int k){
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		
		for(int i = 0 ; i < arr.length ; i++){
			if(i < k ){
				heap.add(arr[i]);
				if(i == k - 1)
					System.out.println(heap.remove());
			}
			else{
				if(arr[i] > heap.peek()){
					heap.remove();
					heap.add(arr[i]);
				}
				System.out.println(heap.peek());
			}
		}
	}
}
