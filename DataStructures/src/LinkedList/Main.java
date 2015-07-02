package LinkedList;

public class Main {
	public static void main(String[] args) {
		//Tests for all Linked lists
		SingleLL ll1 = new SingleLL(2);
		ll1.insert(1);ll1.insert(4);ll1.insert(2);ll1.insert(1);
		ll1.printList();
		LLAlgos.reverseK(ll1.getHead(), 3);
		ll1.printList();
	}
}
