package Heaps;

public class MinHeap {
	
	private int[] heap ;
	private int size ;
	private int max_size ;
	
	private static final int FRONT = 1;
	
	public MinHeap(int max_size) {
		this.max_size = max_size; 
		heap = new int[max_size + 1];
		this.size = 0 ;
		heap[0] = Integer.MIN_VALUE;
	}
	
	private int getParent(int pos){
		return pos/2;
	}
	
	private int getLeftChild(int pos){
		return pos*2; 
	}
	
	private int getRightChild(int pos){
		return (pos*2) + 1; 
	}
	
	public boolean isLeaf(int pos){
		if(pos > (size / 2) && pos <= size)
			return true; 
		return false; 
	}
	
	private void swap(int pos1, int pos2){
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp; 
	}
	
	private void minHeapify(int pos){
		if(!isLeaf(pos)){
			if(heap[pos] > heap[getLeftChild(pos)] || heap[pos] > heap[getRightChild(pos)]){
				if(heap[getLeftChild(pos)] < heap[getRightChild(pos)]){
					swap(pos, getLeftChild(pos));
					minHeapify(getLeftChild(pos));
				}
				else{
					swap(pos, getRightChild(pos));
					minHeapify(getRightChild(pos));
				}
			}
		}
	}
	
	public void insert(int element){
		heap[++size] = element;
		int current = size; 
		
		while(heap[current] < heap[getParent(current)]){
			swap(current, getParent(current));
			current = getParent(current);
		}
	}
	
	public void printHeap(){
		for(int i = 1 ; i <= size/2 ; i++){
			System.out.print("Parent : " + heap[i] + " ");
			if(getLeftChild(i) <= size){
				System.out.print("left " + heap[getLeftChild(i)]);
			}
			if(getRightChild(i) <= size){
				System.out.print(" Right " + heap[getRightChild(i)]);
			}
			System.out.println();
		}
	}
	
	public void minHeap(){
		for(int pos = (size/2) ; pos>= 1 ; pos--)
			minHeapify(pos);
	}
	
	public int remove(){
		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		minHeapify(FRONT);
		return popped;
	}
	
	public int getTopElement(){
		return heap[FRONT];
	}
	
	public boolean isEmpty(){
		return (size==1);
	}
}
