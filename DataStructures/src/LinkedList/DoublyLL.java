package LinkedList;

public class DoublyLL {
	// Pointer to head node
	private DoubleNode headNode;

	public DoublyLL(int data) {
		headNode = new DoubleNode(data);
	}
	
	public DoublyLL(DoubleNode head) {
		headNode = head;
	}

	// Get total elements in a LL
	public int size() {
		return size(headNode);
	}
	
	public DoubleNode getHead(){
		return headNode;
	}

	public int size(DoubleNode node) {
		int count = 0;
		DoubleNode current = node;
		while (current != null) {
			current = current.getNext();
			count += 1;
		}
		return count;
	}

	// for inserting new element at the end
	public DoubleNode insert(int data) {
		return insert(headNode, data, size() + 1);
	}

	// for inserting new element at the specified position
	public DoubleNode insert(int data, int position) {
		return insert(headNode, data, position);
	}

	public DoubleNode insert(DoubleNode node, int data, int position) {
		if (position < 1 || position > size() + 1)
			throw new IllegalArgumentException("Incorrect argument specified");

		//Inserting at head position
		if (position == 1) {
			DoubleNode newNode = new DoubleNode(data);
			newNode.setNext(node);
			newNode.setPrev(null);
			node.setPrev(newNode);
			headNode = newNode;
		} 
		else 
		{
			// insert at position
			DoubleNode current = node;
			int count = 1;
			while (count < position - 1) 
			{
				current = current.getNext();
				count++;
			}
			DoubleNode newNode = new DoubleNode(data);
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

	public int getDataforPosition(DoubleNode node, int position) {
		if (position < 1 || position > size() + 1)
			throw new IllegalArgumentException(
					"Incorrect argument for position");

		if (position == 1) {
			return node.getData();
		} else {
			DoubleNode current = node;
			int count = 1;
			while (count < position) {
				current = current.getNext();
				count++;
			}
			return current.getData();
		}
	}

	// Delete an element from the given position
	public DoubleNode delete(int position) {
		return delete(headNode, position);
	}

	public DoubleNode delete(DoubleNode node, int position) {

		if (position < 0 || position > size() + 1)
			throw new IllegalArgumentException("Cannot delete at this position");

		if (position == 1)
		{	
			headNode = headNode.getNext();
		}
		else {
			DoubleNode current = node;
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
		DoubleNode current = headNode;
		while (current != null) {
			System.out.print(current.getData() + "<==>");
			current = current.getNext();
		}

		System.out.println("NULL");
		System.out.println();
	}

	// Returns the position of data specified in data, if not returns -1
	public int find(int data) {
		return find(headNode, data);
	}

	public int find(DoubleNode node, int data) {
		DoubleNode current = node;
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
