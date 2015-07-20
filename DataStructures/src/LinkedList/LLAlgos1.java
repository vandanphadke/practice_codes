package LinkedList;

import java.util.HashSet;


public class LLAlgos1 {

	static Node left; 
	//This is an implementation of checking of a singly linked list for a palindrome
	public static boolean checkifPalindrome(SingleLL ll){
		
		Node head = ll.getHead();
		left = head; 
		return checkIfPalindromeRecurse(head);
	
	}
	
	public static boolean checkIfPalindromeRecurse(Node right){
		
		if(right == null)
			return true;
		
		boolean isPal = checkIfPalindromeRecurse(right.getNext());
		
		if(isPal == false)
			return false; 
		
		System.out.println(left.getData() + "   " + right.getData());
		boolean isp1 = (left.getData() == right.getData());
		
		left = left.getNext();
		
		return isp1;
	}
	
	public static void removeDuplicates(SingleLL ll){
		Node head = ll.getHead();
		if(head == null)
			return;
		Node current = head ; 
		
		while(current.getNext() != null){
			if(current.getData() == current.getNext().getData()){
				current.setNext(current.getNext().getNext());
			}
			else
				current = current.getNext(); 
		}
	}
	
	public static void deleteAlternate(SingleLL linkedlist){
		Node head = linkedlist.getHead();
		Node current = head;
		
		while(current.getNext() != null){
			if(current.getNext().getNext() == null){
				current.setNext(null);
				break; 
			}	
			else{
				current.setNext(current.getNext().getNext());
				current = current.getNext();
			}
		}
	}
	
	public static Node mergeSortLinkedList(SingleLL linkedList){
		Node head = linkedList.getHead();
		return mergeSortLinkedList(head);
	}
	
	public static Node mergeSortLinkedList(Node headOriginal) 
    {
        if (headOriginal == null || headOriginal.getNext() == null)
            return headOriginal;
        Node a = headOriginal;
        Node b = headOriginal.getNext();
        while ((b != null) && (b.getNext() != null)) 
        {
            headOriginal = headOriginal.getNext();
            b = (b.getNext()).getNext();
        }
        b = headOriginal.getNext();
        headOriginal.setNext(null); 
        return mergeSorted(mergeSortLinkedList(a), mergeSortLinkedList(b));
    }
	
	public static Node mergeSorted(Node a, Node b) 
    {
        Node temp = new Node();
        Node head = temp;
        Node c = head;
        while ((a != null) && (b != null)) 
        {
            if (a.getData() <= b.getData()) 
            {
                c.setNext(a);
                c = a;
                a = a.getNext();
            }
            else 
            {
                c.setNext(b);
                c = b;
                b = b.getNext();
            }
        }
        c.setNext((a == null) ? b : a);
        return head.getNext();
    }
	
	public static Node reverseK(Node head, int k){
		Node current = head;
		Node prev = null ;
		Node next = null ;
		int i = 0 ;
		
		while( current != null && i  < k){
			next = current.getNext();
			current.setNext(prev);
			prev = current ; 
			current = next ;
			i++; 
		}
		
		if(next != null)
			head.setNext(reverseK(next, k));
		
		return prev;
	}
	
	public void removeDuplicatefromUnsorted(SingleLL linkedlist){
		Node head = linkedlist.getHead();
		HashSet<Node> set = new HashSet<Node>();
		Node current = head;
		while(current != null){
			if(set.contains(current)){
				//Delete linkedlist node here
			}
			else
				set.add(current);
		}
	}
}
