package LinkedList;

public class DoubleNode {
	private int data;
	private DoubleNode next;
	private DoubleNode prev; 

	public DoubleNode(int data) {this.data = data;}

	public int getData() {return data;}

	public void setData(int data) {this.data = data;}

	public DoubleNode getNext() {return next;}

	public void setNext(DoubleNode next) {this.next = next;}
	
	public DoubleNode getPrev() {return prev;}

	public void setPrev(DoubleNode prev) {this.prev = prev;}
}
