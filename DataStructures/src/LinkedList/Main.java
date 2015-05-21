package LinkedList;

public class Main {
	public static void main(String[] args) {
		//Tests for all Linked lists
		CircularLL linkedList  = new CircularLL(10);
		linkedList.insert(20);
		linkedList.insert(30);
		linkedList.insert(40);
		linkedList.insert(50);
		linkedList.printList();
		linkedList.delete(3);
		linkedList.printList();
		System.out.println(linkedList.getDataforPosition(2));
	}
}
