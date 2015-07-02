package Trees;

public class Node {
	
	private int key = 0 ; 
	private Node left = null;
	private Node right = null ;
	
	public Node(int value)
	{
		key = value ; 
	}
	
	public int getKey() {return key;}
	
	public void setKey(int key) {this.key = key;}
	
	public Node getLeft() {return left;}
	
	public void setLeft(Node left) {this.left = left;}
	
	public Node getRight() {return right;}
	
	public void setRight(Node right) {this.right = right;} 
}
