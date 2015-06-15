package Stack;

import LinkedList.SingleLL;

public class StackLL {
	
	SingleLL linkedlist; 
	
	public StackLL(int value) {
		// TODO Auto-generated constructor stub
		linkedlist = new SingleLL(value);
	}
	
	public void push(int value)
	{
		linkedlist.insert(value,1);	
	}
	
	public int pop() throws Exception
	{
		if(isEmpty())
			throw new Exception("Stack is empty");
		
		int value = linkedlist.getDataforPosition(1);
		linkedlist.delete(1);
		return value;
	}
	
	public int peek() throws Exception
	{
		return linkedlist.getDataforPosition(1);
	}
	
	public boolean isEmpty()
	{
		if(linkedlist.size() == 0)
			return true; 
		else
			return false; 
	}
}
