package Heaps;

public class Main {
	public static void main(String[] args) {
		int[] heap = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		MaxHeap max_heap = new MaxHeap(heap);
		max_heap.heapSort();
		max_heap.printHeap();
	}
}
