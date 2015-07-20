package LinkedList;

import java.util.Stack;

/**
 * Q: Given two numbers represented by two linked lists, write a function that returns sum list
 * Input:
   First List: 5->6->3  // represents number 563
   Second List: 8->4->2 //  represents number 842
   Output
   Resultant list: 1->4->0->5  // represents number 1405
 * @author Vandan Phadke
 *
 */
public class AddLLNumbers {
	public static void main(String[] args) {
		SingleLL ll1 = new SingleLL(9);
		ll1.insert(4);ll1.insert(4);
		SingleLL ll2 = new SingleLL(1);
		ll2.insert(2);ll2.insert(2);ll2.insert(4);ll2.insert(1);
		getSum(ll1.getHead(), ll2.getHead()).printList();;
	}
	
	public static SingleLL getSum(Node first, Node second){
		Node current1 = first, current2 = second;
		SingleLL ll = new SingleLL(0);
		ll.delete(1);
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		while(current1 != null){
			s1.push(current1);
			current1 = current1.getNext();
		}
		while(current2 != null){
			s2.push(current2);
			current2 = current2.getNext();
		}
		int carry = 0 ;
		while(!s1.isEmpty() && !s2.isEmpty()){
			int sum = s1.pop().getData() + s2.pop().getData() + carry;
			System.out.println(sum);
			if(sum >= 10){
				carry = 1 ;
				sum = sum % 10 ; 
			}
			ll.insert(sum, 1);
		}

		if(!s1.isEmpty())
			while(!s1.isEmpty())
				ll.insert(1,s1.pop().getData());
		
		if(!s2.isEmpty())
			while(!s2.isEmpty())
				ll.insert(1,s2.pop().getData());
			
		if(carry == 1)
			ll.insert(1,1);
		return ll ;
	}
}
