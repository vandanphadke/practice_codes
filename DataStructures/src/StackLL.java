
public class StackLL {
	LinkedList linkedList ; 
	
	public StackLL(int data) {
		// TODO Auto-generated constructor stub
		linkedList = new LinkedList(data);
	}
	
	public void push(int data)
	{
		linkedList.insert(data,1);
	}
	
	public int pop()
	{
		int data = linkedList.getDataforPosition(1);
		linkedList.delete(1);
		return data;
	}
	
	public void printStack(){linkedList.printList();}
}
