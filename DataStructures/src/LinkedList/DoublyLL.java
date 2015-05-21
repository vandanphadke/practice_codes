package LinkedList;

public class DoublyLL {
	// Pointer to head node
	private Node headNode;

	// Individual Node class
	public class Node {
		private int data;
		private Node next;
		private Node prev; 

		public Node(int data) {this.data = data;}

		public int getData() {return data;}

		public void setData(int data) {this.data = data;}

		public Node getNext() {return next;}

		public void setNext(Node next) {this.next = next;}
		
		public Node getPrev() {return prev;}

		public void setPrev(Node prev) {this.prev = prev;}
	}

	public DoublyLL(int data) {
		headNode = new Node(data);
	}

	// Get total elements in a LL
	public int size() {
		return size(headNode);
	}

	public int size(Node node) {
		int count = 0;
		Node current = node;
		while (current != null) {
			current = current.getNext();
			count += 1;
		}
		return count;
	}

	// for inserting new element at the end
	public Node insert(int data) {
		return insert(headNode, data, size() + 1);
	}

	// for inserting new element at the specified position
	public Node insert(int data, int position) {
		return insert(headNode, data, position);
	}

	public Node insert(Node node, int data, int position) {
		if (position < 1 || position > size() + 1)
			throw new IllegalArgumentException("Incorrect argument specified");

		//Inserting at head position
		if (position == 1) {
			Node newNode = new Node(data);
			newNode.setNext(node);
			newNode.setPrev(null);
			node.setPrev(newNode);
			node = newNode;
		} 
		else 
		{
			// insert at position
			Node current = node;
			int count = 1;
			while (count < position - 1) 
			{
				current = current.getNext();
				count++;
			}
			Node newNode = new Node(data);
			newNode.setNext(current.getNext());
			newNode.setPrev(current);
			current.setNext(newNode);
			if(newNode.getNext() != null)
				newNode.getNext().setPrev(newNode);
				
		}
		return node;
	}

	// Get element in the specified position
	public int getDataforPosition(int position) {
		return getDataforPosition(headNode, position);
	}

	public int getDataforPosition(Node node, int position) {
		if (position < 1 || position > size() + 1)
			throw new IllegalArgumentException(
					"Incorrect argument for position");

		if (position == 1) {
			return node.getData();
		} else {
			Node current = node;
			int count = 1;
			while (count < position) {
				current = current.getNext();
				count++;
			}
			return current.getData();
		}
	}

	// Delete an element from the given position
	public Node delete(int position) {
		return delete(headNode, position);
	}

	public Node delete(Node node, int position) {

		if (position < 0 || position > size() + 1)
			throw new IllegalArgumentException("Cannot delete at this position");

		if (position == 1)
		{	
			node = node.getNext();
			node.setPrev(null);
		}
		else {
			Node current = node;
			int count = 1;
			while (count < position - 1) {
				current = current.getNext();
				count++;
			}

			current.setNext(current.getNext().getNext());
			current.getNext().setPrev(current);
		}
		return node;
	}

	// Print a given linkedlist
	public void printList() {
		Node current = headNode;
		while (current != null) {
			System.out.print(current.data + "<==>");
			current = current.getNext();
		}

		System.out.println("NULL");
		System.out.println();
	}

	// Returns the position of data specified in data, if not returns -1
	public int find(int data) {
		return find(headNode, data);
	}

	public int find(Node node, int data) {
		Node current = node;
		int count = 1;
		while (current != null) {
			if (current.getData() == data)
				return count;

			else {
				count++;
				current = current.getNext();
			}
		}

		return -1;
	}
}
