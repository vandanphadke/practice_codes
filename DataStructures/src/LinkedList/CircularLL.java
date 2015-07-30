package LinkedList;

public class CircularLL {
	//Pointer to head node
	private Node headNode; 

	//Individual Node class
	public class Node
	{
		private int data ; 
		private Node next ; 

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
	}

	public CircularLL(int data){
		headNode = new Node(data);
		headNode.setNext(headNode);
	}

	//Get total elements in a LL
	public int size(){return size(headNode);}

	public int size(Node node){
		int count=0;
		Node current = node;
		while(current.getNext() != headNode){
			current = current.getNext();
			count+=1;
		}
		return count;
	}

	//for inserting new element at the end
	public Node insert(int data){return insert(headNode, data, size() + 1);}

	//for inserting new element at the specified position
	public Node insert(int data, int position){return insert(headNode, data, position);}

	public Node insert(Node node, int data, int position)
	{
		if(position < 1 || position > size() + 1)
			throw new IllegalArgumentException("Incorrect argument specified");

		if(position == 1){
			Node newNode = new Node(data);
			Node current = node;
			while(current.getNext() != headNode)
			{
				current = current.getNext();
			}
			newNode.setNext(node);
			current.setNext(newNode);
			headNode = newNode;
		}
		else if(position == size() + 1)
		{
			Node current = node;
			Node newNode = new Node(data);
			newNode.setNext(node);
			while(current.getNext() != headNode)
			{
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		else{
			//insert at any other position than first or last
			Node current = node;
			int count = 1 ; 
			while(count < position - 1){
				current = current.getNext();
				count++ ; 
			}	
			Node newNode = new Node(data);
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
		return node; 
	}

	//Get element in the specified position
	public int getDataforPosition(int position){return getDataforPosition(headNode, position);}

	public int getDataforPosition(Node node, int position)
	{
		if(position < 1 || position > size() + 1)
			throw new IllegalArgumentException("Incorrect argument for position");

		if(position == 1){
			return node.getData(); 
		}
		else{
			Node current = node;
			int count = 1 ; 
			while(count < position){
				current = current.getNext();
				count++ ; 
			}	
			return current.getData();
		}
	}

	//Delete an element from the given position
	public Node delete(int position){return delete(headNode, position);}

	public Node delete(Node node, int position)
	{

		if(position < 0 || position > size() + 1)
			throw new IllegalArgumentException("Cannot delete at this position");

		if(position == 1)
		{
			//headNode = headNode.getNext();
			Node current = node;
			while(current.getNext() != headNode){
				current = current.getNext();
			}
			headNode = current.getNext().getNext();
			current.setNext(current.getNext().getNext());
		}
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

	//Print a given linkedlist
	public void printList()
	{
		Node current = headNode ; 
		while(current.getNext() != headNode)
		{
			System.out.print(current.data + "-->");
			current = current.getNext();
		}
		
		System.out.print(current.data + "-->");
		System.out.println("HEAD");
		System.out.println();
	}

	//Returns the position of data specified in data, if not returns -1
	public int find(int data) {return find(headNode, data);}


	public int find(Node node, int data)
	{
		Node current = node ;
		int count = 1 ; 
		while(current.getNext() != headNode)
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
