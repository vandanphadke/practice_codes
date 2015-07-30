package Heaps;

import java.util.PriorityQueue;
/**
 * Q: Given an array of n elements, where each element is at most k away from its target position, 
 * devise an algorithm that sorts in O(n log k) time.
 * 
 * Algo: 1) Create a Min Heap of size k+1 with first k+1 elements. 
 * 			This will take O(k) time (See this GFact)
		 2) One by one remove min element from heap, put it in result array, 
			and add a new element to heap from remaining elements.			
 * @author Vandan Phadke
 */
public class KSortedArray {
	public static void main(String[] args) {
		int[] arr = {2, 6, 3, 12, 56, 8};
		int k = 3;
		sortKSortedArray(arr, k);
	}
	
	public static void sortKSortedArray(int[] arr, int k){
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		
		for(int i = 0 ; i <= k ; i++){
			heap.add(arr[i]);
		}
		
		for(int i = k + 1 ; i < arr.length ; i++){
			System.out.print(heap.remove() + " ");
			heap.add(arr[i]);
		}
		while(!heap.isEmpty()){
			System.out.print(heap.remove() + " ");
		}
	}
}


