package Trees;

import java.util.Arrays;
import java.util.Stack;

public class TreeTraversals {
	
	public static void iterativePreorder(Node root){
		Stack<Node> q = new Stack<Node>();
		q.push(root);
		Node current; 
		while(!q.isEmpty()){
			current = q.pop();
			System.out.print(current.getKey());
			if(current.getRight() != null)
				q.add(current.getRight());
			if(current.getLeft() != null)
				q.add(current.getLeft());
		}
	}
	
	public static void iterativeInorder(Node root){
		Node current = root ;
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || current != null){
			if(current != null){
				stack.push(current);
				current = current.getLeft();
			}
			else{
				current = stack.pop();
				System.out.print(current.getKey());
				current = current.getRight();
			}
		}
	}
	
	/**
	 * Prints the entire tree in zigzag order
	 * @param root of binary tree
	 */
	public static void zigzagTreeTraversal(Node root){
		if(root == null)
			return;
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.push(root);
		
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				Node temp = s1.pop();
				System.out.print(temp.getKey());
				
				if(temp.getRight() != null)
					s2.push(temp.getRight());
				
				if(temp.getLeft() != null)
					s2.push(temp.getLeft());
			}
			System.out.println();
			while(!s2.isEmpty()){
				Node temp = s2.pop();
				System.out.print(temp.getKey());
				
				if(temp.getLeft() != null)
					s1.push(temp.getLeft());
				
				if(temp.getRight() != null)
					s1.push(temp.getRight());
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints all the root to leaf paths in a binary tree
	 * @param root
	 */
	public static void printAllPaths(Node root){
		int[] path = new int[10];
		printAllPathsRecurse(root, path, 0);
	}
	
	public static void printAllPathsRecurse(Node root, int[] path, int len){
		if(root == null)
			return ; 
		path[len] = root.getKey();
		len++;
		
		if(root.getLeft() == null && root.getRight() == null){
			System.out.println(Arrays.toString(path));
			return; 
		}
		
		printAllPathsRecurse(root.getLeft(), path, len);
		printAllPathsRecurse(root.getRight(), path, len);
	}
}
