package LinkedList;

public class Main {
	public static void main(String[] args) {
		//Tests for all Linked lists
		SingleLL linkedList  = new SingleLL(10);
		linkedList.insert(20);
		linkedList.insert(30);
		linkedList.insert(50);
		linkedList.insert(30);
		linkedList.insert(20);
		linkedList.insert(10);
		linkedList.printList();
		//linkedList.insert(50);
		
		System.out.println(LLAlgos.checkifPalindrome(linkedList));
	}
}
