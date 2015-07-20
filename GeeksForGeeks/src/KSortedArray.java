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
	
	public static int[] sortKSortedArray(int[] arr, int k){
		KSortedArray a = new KSortedArray();
		KSortedArray.MinHeap heap = a.new MinHeap(k+1);
		
		for(int i = 0 ; i <= k ; i++){
			heap.insert(arr[i]);
		}
		heap.printHeap();
		System.out.println(heap.remove());
		heap.printHeap();
		System.out.println(heap.remove());
		heap.printHeap();
		return null; 
	}
	
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
		
		private boolean isLeaf(int pos){
			if(pos >= (size / 2) && pos <= size)
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
	}
}


