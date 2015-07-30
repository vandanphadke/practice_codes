package Trees;

/**
 * Q: The diameter of a tree (sometimes called the width) is the number of nodes on the 
 * longest path between two leaves in the tree. 
 * @author Vandan Phadke
 *
 */
public class DiameterOfATree {
	
	public static int getDiameter(Node root) {        
	    if (root == null)
	        return 0;

	    int rootDiameter = getHeight(root.getLeft()) + getHeight(root.getRight()) + 1;
	    int leftDiameter = getDiameter(root.getLeft());
	    int rightDiameter = getDiameter(root.getRight());

	    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
	}

	public static int getHeight(Node root) {
	    if (root == null)
	        return 0;

	    return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
	}
}
