package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

	private Node head;

	public BST(int value) {
		head = new Node(value);
	}

	public Node getHeadNode() {
		return head;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void insert(int data) {
		head = insert(head, data);
	}

	private Node insert(Node node, int data) {
		if (node == null)
			node = new Node(data);
		else {
			Node current = node ;
			Node parent = node ;
			while(current != null){
				parent = current ;
				if(current.getKey() < data)
					current = current.getRight();
				else if(current.getKey() > data)
					current = current.getLeft();
				else
					break ;
			}
			if(parent.getKey() < data)
				parent.setRight(new Node(data));
			else
				parent.setLeft(new Node(data));
		}
		return node;
	}

	public void printInorder()
	{
		printInorder(head);
	}
	
	private void printInorder(Node node) {
		if (node == null)
			return;

		printInorder(node.getLeft());
		System.out.print(node.getKey());
		printInorder(node.getRight());
	}
	
	public void printPreorder()
	{
		printPreorder(head);
	}
	
	private void printPreorder(Node node) {
		if (node == null)
			return;

		System.out.print(node.getKey());
		printPreorder(node.getLeft());
		printPreorder(node.getRight());
	}

	public int getHeight()
	{
		return getHeight(head);
	}
	
	private int getHeight(Node node) {
 
		if (node == null)
			return 0;

		else {
			/* compute the height of each subtree */
			int lheight = getHeight(node.getLeft());
			int rheight = getHeight(node.getRight());

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}
	
	public void printLevelOrder()
	{
		printLevelOrder(head);
	}
	/* Function to print level order traversal a tree*/
	private void printLevelOrder(Node root)
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node current = queue.remove();
			System.out.println(current.getKey());
			if(current.getLeft() != null)
				queue.add(current.getLeft());
			if(current.getRight() != null)
				queue.add(current.getRight());
		}
	}    
	
	public boolean searchKey(int value)
	{
		Node current = head ; 
		while(current != null)
		{
			if(current.getKey() == value)
				return true ; 
			
			else if(current.getKey() > value)
				current = current.getLeft();
			
			else
				current = current.getRight();
		}
		return false ; 
	}
	
	/* Functions to delete data */
    public void delete(int k)
    {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (searchKey(k) == false)
            System.out.println("Sorry "+ k +" is not present");
        else
        {
            head = delete(head, k);
            System.out.println(k+ " deleted from the tree");
        }
    }
    
    /* Given a binary search tree and a key, this function deletes the key
    and returns the new root */
    Node delete(Node root, int key)
    {
     // base case
     if (root == null) return root;
  
     // If the key to be deleted is smaller than the root's key,
     // then it lies in left subtree
     if (key < root.getKey())
         root.setLeft(delete(root.getLeft(), key));
  
     // If the key to be deleted is greater than the root's key,
     // then it lies in right subtree
     else if (key > root.getKey())
         root.setRight(delete(root.getRight(), key));
  
     // if key is same as root's key, then This is the node
     // to be deleted
     else
     {
         // node with only one child or no child
         if (root.getLeft() == null)
         {
             Node temp = root.getRight();
             return temp;
         }
         else if (root.getRight() == null)
         {
             Node temp = root.getLeft();
             return temp;
         }
  
         // node with two children: Get the inorder successor (smallest
         // in the right subtree)
         Node temp = minValueNode(root.getRight());
  
         // Copy the inorder successor's content to this node
         root.setKey(temp.getKey());  
  
         // Delete the inorder successor
         root.setRight(delete(root.getRight(), temp.getKey())); 
     }
     return root;
    }
    
    Node minValueNode(Node node)
    {
        Node current = node;
     
        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null)
            current = current.getLeft();
     
        return current;
    }

    /* Function to find LCA of n1 and n2 */
    public Node lca(Node root, int n1, int n2)
    {
    	if((searchKey(n1) || searchKey(n2)) != true)
    		return null;
    	
    	if (root == null) return null;
  
    	// If both n1 and n2 are smaller than root, then LCA lies in left
    	if (root.getKey() > n1 && root.getKey() > n2)
    		return lca(root.getLeft(), n1, n2);
  
    	// If both n1 and n2 are greater than root, then LCA lies in right
    	if (root.getKey() < n1 && root.getKey() < n2)
    		return lca(root.getRight(), n1, n2);
  
    	return root;
    }

}
