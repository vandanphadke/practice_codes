package Heaps;

import java.util.Arrays;

public class MaxHeap {
	int heap_count = 0 ;
	int[] data;
	
	public MaxHeap(int[] heap){
		this.heap_count = heap.length;
		data = heap;
	}
	
	public int getParent(int i){
		return i/2;
	}
	
	public int getLeftChild(int parent){
		return 2*parent + 1; 
	}
	
	public int getRightChild(int parent){
		return 2*parent + 2; 
	}
	
	public void max_heapify(int index){
		int largest = index;
		if(getLeftChild(index) >= heap_count - 1 )
			return ; 
		if(data[index] > data[getLeftChild(index)] )
			largest = index;
		else
			largest = getLeftChild(index);
		
		if(data[largest] < data[getRightChild(index)])
			largest = getRightChild(index);
		
		if(largest != index){
			//Swap elements largest and index
			int temp = data[largest];
			data[largest] = data[index];
			data[index] = temp ;
			max_heapify(largest);
		}
	}
	
	public void printHeap(){
		System.out.println(Arrays.toString(data));
	}
	
	public void build_max_heap(){
		for(int i = data.length / 2 ; i >= 0 ; i--)
			max_heapify(i);
	}
	
	public void heapSort(){
		build_max_heap();
		for(int i = data.length - 1 ; i > 1 ; i--){
			int temp = data[i];
			data[i] = data[0];
			data[0] = temp ;
			printHeap();
			--heap_count;
			max_heapify(0);
		}
	}
	
}
