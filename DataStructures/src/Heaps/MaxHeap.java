package Heaps;

public class MaxHeap {
	private static final int FRONT = 1 ; 
	private int[] heap ;
	private int size = 0;
	private int max_size;
	
	public MaxHeap(int max_size){
		this.max_size = max_size;
		heap = new int[max_size + 1];
		heap[0] = Integer.MAX_VALUE;
	}
	
	private int parent(int pos){
		return (pos/2);
	}
	
	private int leftChild(int pos){
		return 2*pos;
	}
	
	private int rightChild(int pos){
		return (2*pos + 1);
	}
	
	public void insert(int element){
		if(size + 1 > max_size)
			throw new IllegalArgumentException("Inserting element greater than max size");
		
		heap[++size] = element;
		int current = size;
		while(heap[current] > heap[parent(current)]){
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	private void swap(int pos1, int pos2){
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp; 
	}
	
	private boolean isLeaf(int pos){
		if(pos > (size/2) && pos<= size)
			return true;
		return false; 
	}
	
	private void maxHeapify(int pos){
		if(!isLeaf(pos)){
			if(heap[pos] < leftChild(pos) || heap[pos] < rightChild(pos)){
				if(leftChild(pos) > rightChild(pos)){
					swap(pos, leftChild(pos));
					maxHeapify(leftChild(pos));
				}
				else{
					swap(pos, rightChild(pos));
					maxHeapify(rightChild(pos));
				}
			}
		}
	}
	
	private void buildMaxHeap(){
		for(int i = size/2 ; i >= 1 ; i--){
			maxHeapify(i);
		}
	}
	
	public void printHeap(){
		for(int i = 1 ; i <= size/2 ; i++){
			System.out.print("Parent : " + heap[i] + " ");
			if(leftChild(i) <= size){
				System.out.print("left " + heap[leftChild(i)]);
			}
			if(rightChild(i) <= size){
				System.out.print(" Right " + heap[rightChild(i)]);
			}
			System.out.println();
		}
	}
	
	public int remove(){
		int removed_element = heap[FRONT];
		heap[FRONT] = heap[size--];
		maxHeapify(FRONT);
		return removed_element;
	}
	
	public int getTopElement(){
		return heap[FRONT];
	}
}
