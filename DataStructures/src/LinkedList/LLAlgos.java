package LinkedList;

import LinkedList.SingleLL.Node;

public class LLAlgos {

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
}
