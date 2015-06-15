package Queue;

public class CircularArray {
	
	private int front = -1;
	private int rear = -1;
	private int[] data ;
	
	public CircularArray(int size)
	{
		data = new int[size];
	}
	
	public boolean isEmpty()
	{
		if(front == -1)
			return true; 
		else
			return false; 
	}
}
