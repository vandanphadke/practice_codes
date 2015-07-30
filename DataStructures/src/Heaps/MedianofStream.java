package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Q:Given that integers are read from a data stream. 
 * Find median of elements read so for in efficient way 	
 * @author Vandan Phadke
 *
 */
public class MedianofStream {
	public static void main(String[] args) {
		int[] stream = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
	}
	
	public static void getMedian(int current, int median){
		PriorityQueue<Integer> r = new PriorityQueue<Integer>();
		PriorityQueue<Integer> l = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return Integer.compare(b, a);
			}
		});
		
		int m = 0 ; 
		int balanced = isBalanced(l.size(), r.size());
		if(balanced == 1){
			if(current < median){
				r.add(l.poll());
				l.add(current);
			}else
				r.add(current);
			
			m = (l.peek() + r.peek())/2;
		}
		else if(balanced == 0){
			
		}
	}
	
	public static int isBalanced(int a, int b){
		if(a == b)
			return 0; 
		else
			return (a < b ? -1 : 1);
	}
}
