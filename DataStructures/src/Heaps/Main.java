package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args){
		MaxHeap heap = new MaxHeap(9);
		for(int i = 8; i >= 0 ; i--)
			heap.insert(i);
		heap.printHeap();
		
		/*PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				return (Integer.compare(str1.length(), str2.length()));
			}
		});
	
		queue.add("AB");queue.add("A");queue.add("ABCCDEF");queue.add("ABC");
		while(!queue.isEmpty())
			System.out.println(queue.poll());*/

	    
	}
}
