package Trees;

public class BSTAlgos {
	
	/**
	 * Q: Implement a function to check if a binary tree is balanced. For the purposes of this
		  question, a balanced tree is defined to be a tree such that the heights of the two
		  subtrees of any node never differ by more than one
	 * @param Root node of tree
	 * @return if tree is balanced or not
	 */
	public static boolean  checkBalanced(Node root) {
		if(checkIfBalanced(root) == -1)
			return false;
		else
			return true;
	}
	
	public static int checkIfBalanced(Node root){
		if(root == null)
			return 0; 
		
		int leftHeight = checkIfBalanced(root.getLeft());
		if(leftHeight == -1)
			return -1;
		
		int rightHeight = checkIfBalanced(root.getRight());
		if(rightHeight == -1)
			return -1;
		
		if(Math.abs(leftHeight - rightHeight) > 1)
			return -1; 
		else
			return Math.max(leftHeight, rightHeight)+1; 
	}

	/**
	 * @param root Root Node of a Binary Tree
	 * @return if tree is BST or not
	 */
	public static boolean checkIfBst(Node root)
	{
		return (checkIfBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	public static boolean checkIfBst(Node node, int min, int max)
	{
		/* an empty tree is BST */
		  if (node==null) 
		     return true;
		       
		  /* false if this node violates the min/max constraint */ 
		  if (node.getKey() < min || node.getKey() > max) 
		     return false; 
		 
		  /* otherwise check the subtrees recursively, 
		   tightening the min or max constraint */
		  return
				  checkIfBst(node.getLeft(), min, node.getKey()-1) &&  // Allow only distinct values
				  checkIfBst(node.getRight(), node.getKey()+1, max);  // Allow only distinct values
	}
	
	/**
	 * @param Root to BST, two nodes whose lca is to be found
	 * @return LCA of the two nodes
	 */
	public static int lca(Node root, int l, int r){
		Node current = root; 
		while(current != null){
			if(current.getKey() < l && current.getKey() < r)
				current = current.getRight();
			else if(current.getKey() > l && current.getKey() > r)
				current = current.getLeft();
			else
				break;
		}
		return current.getKey(); 
	}
	
	/**
	 * Get inorder successor of a tree
	 * @param Root of BST
	 * @param DoubleNode whose successor is to be found
	 */
	public static int getInorderSuccessor(Node root, int n){
		Node current = root, succ = null; 
		while(current != null){
			if(n < current.getKey()){
				current = current.getLeft();
				succ = root;
			}
			else if(n > current.getKey())
				current = current.getRight();
			
			else
				break;
		}
		return succ.getKey(); 
	}
	
	/**
	 * @param root Binary Tree root
	 * @return size of maximum BST subtree
	 */
	public static int findLargestBSTSubtree(Node root){
		
		return 0 ; 
	}
	
	public static int findLargestBSTSubtreeUtil(Node root, int min, int max, int maxnodes, Node largest){
		if(root == null)
			return 0;
		
		boolean isBST = true;
		int leftNodes = findLargestBSTSubtreeUtil(root.getLeft(), min, max, maxnodes, largest);
		int currMin = (leftNodes == 0)? root.getKey() : min ;
		if(leftNodes == -1 || leftNodes != 0 && root.getKey() <= max)
			isBST = false;
		
		return 0 ; 
	}
	
	/**
	 * Returns the key closest to n present in the BST
	 * @param root
	 * @param n
	 * @return
	 */
	public static int getCeil(Node root, int n){
		if(root == null)
			return -1;
		
		if(root.getKey() == n)
			return n ;
		
		if(root.getKey() < n)
			return getCeil(root.getRight(), n);
		
		int ceil = getCeil(root.getLeft(), n);
		if(ceil >= n)
			return ceil; 
		else
			return root.getKey();
	}
	
	public static int convertToBST(Node root){
		if(root == null)
			return 0; 
		
		int old_val = root.getKey();
		
		root.setKey(convertToBST(root.getLeft()) + convertToBST(root.getRight()));
		
		return old_val + root.getKey();
	}
	
}
