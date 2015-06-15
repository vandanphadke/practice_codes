package Stack;

public class StackArr {
	
	private int[] data ; 
	private int top = -1;
	private static final int MAX_SIZE = 2; 
	
	public StackArr() {
		// TODO Auto-generated constructor stub
		data = new int[MAX_SIZE];
	}
	
	public void push(int value) throws Exception
	{
		++top;
		if(isFull())
			throw new Exception("Stack is full");
		
		data[top] = value; 
	}
	
	public int pop() throws Exception
	{
		if(isEmpty())
			throw new Exception("Stack is empty");
		
		int value = data[top];
		top--; 
		return value;
	}
	
	public int peek() throws Exception
	{
		if(isEmpty())
			throw new Exception("Stack is empty");
		
		return data[top];
	}
	
	public boolean isEmpty()
	{
		if(top == -1)
			return true; 
		else
			return false; 
	}
	
	public boolean isFull()
	{
		if(top == MAX_SIZE)
			return true; 
		else
			return false; 
	}
}
