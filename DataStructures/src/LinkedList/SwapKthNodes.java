package LinkedList;

/**
 * Q: Swap Kth node from beginning with Kth node from end in a Linked List
 * @author Vandan Phadke
 *
 */
public class SwapKthNodes {
	public static void main(String[] args) {
		DoublyLL linkedList = new DoublyLL(1);
		for(int i = 2 ; i <= 6 ; i++)
			linkedList.insert(i);
		linkedList.printList();
		DoubleNode node = swapKthNodes(linkedList, 3);
		linkedList = new DoublyLL(node);
		linkedList.printList();
	}
	
	public static DoubleNode swapKthNodes(DoublyLL ll, int k){
		DoubleNode head = ll.getHead();
		DoubleNode tail = head;
		int length = 0 ;
		//Make tail node point towards the last node of the ll
		while(tail.getNext() != null){
			tail = tail.getNext();
			++length;
		}
		++length;
		if(k > length || (2*k - 1) == length)
			return head;
		
		DoubleNode first = head, firstprev = null; 
		for(int i = 1 ; i < k ; i++){
			firstprev = first; 
			first = first.getNext();
		}
		
		DoubleNode second = tail, secondnext = null; 
		for(int i = 1 ; i < k ; i++){
			secondnext = second; 
			second = second.getPrev();
		}
		
		if(second.getData() == first.getNext().getData()){
			if(firstprev != null)
				firstprev.setNext(second);
			second.setPrev(firstprev);
			first.setPrev(second);
			second.setNext(first);
			first.setNext(secondnext);
			if(secondnext != null)
				secondnext.setPrev(first);
		}
		else{
			DoubleNode firstnext = first.getNext();
			DoubleNode secondPrev = second.getPrev();
			
			if(firstprev != null)
				firstprev.setNext(second);
			
			second.setPrev(firstprev);
			first.setNext(secondnext);
			
			if(secondnext != null)
				secondnext.setPrev(first);
			secondPrev.setNext(first);
			first.setPrev(secondPrev);
			second.setNext(firstnext);
			firstnext.setPrev(second);
		}
		
		if(k == 1)
			return second;
		else if(k == length)
			return first; 
		else
			return head;
	}
}
