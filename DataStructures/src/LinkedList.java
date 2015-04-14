
public class LinkedList {

	private Node headNode; 

	public class Node
	{
		private int data ; 
		private Node next ; 
		private Node prev ;

		public Node(int data)
		{
			this.data = data ;
		}

		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		} 


	}

	public LinkedList(int data){
		headNode = new Node(data);
	}

	public int size(){
		int count=0;
		Node current = headNode;
		while(current != null){
			current = current.getNext();
			count+=1;
		}
		return count;
	}

	//for inserting newNode at end
	public Node insert(int data){
		return insert(data, size() + 1);
		
	}

	public Node insert(int data, int position)
	{
		if(position == 1){
			Node current = new Node(data);
			current.setNext(headNode);
			headNode = current ; 
		}
		else{
			//insert at position
			Node current = headNode;
			int count = 1 ; 
			while(count < position - 1){
				current = current.getNext();
				count++ ; 
			}	
			Node newNode = new Node(data);
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
		return headNode ; 
	}
	
	public int getDataforPosition(int position)
	{
		if(position == 1){
			return headNode.getData(); 
		}
		else{
			//insert at position
			Node current = headNode;
			int count = 1 ; 
			while(count < position){
				current = current.getNext();
				count++ ; 
			}	
			return current.getData();
		}
	}

	public Node delete(int position)
	{
		if(position < 0)
			throw new IllegalArgumentException("Cannot delete at this position");
		
		if(position == 1)
			headNode = headNode.getNext();
		
		else
		{
			Node current = headNode;
			int count = 1 ; 
			while(count < position - 1){
				current = current.getNext();
				count++ ; 
			}
			
			current.setNext(current.getNext().getNext());
		}
		return headNode ; 
		
	}

	public void printList()
	{
		Node current = headNode ; 
		while(current != null)
		{
			System.out.print(current.data + " ");
			current = current.getNext();
		}
		System.out.println();
	}

	public int find(int data)
	{
		Node current = headNode ;
		int count = 1 ; 
		while(current != null)
		{
			if(current.getData() == data)
				return count ; 
			
			else
			{
				count++ ;
				current = current.getNext();
			}
		}
		
		return -1 ; 
	}
}
