package Trees;

/**
 * Q: Two elements of a binary search tree (BST) are swapped by mistake.
	  Recover the tree without changing its structure.
 * @author Vandan Phadke
 *
 */
public class RecoverBST {
	static Node firstElement = null;
    static Node secondElement = null;
    static Node prevElement = new Node(Integer.MIN_VALUE);
    
    public void recoverTree(Node root) {
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.getKey();
        firstElement.setKey(secondElement.getKey());
        secondElement.setKey(temp);
    }
    
    private static void traverse(Node root) {

        if (root == null)
            return;

        traverse(root.getLeft());

        if (firstElement == null && prevElement.getKey() >= root.getKey()) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.getKey() >= root.getKey()) {
            secondElement = root;
        }        
        prevElement = root;

        traverse(root.getRight());
}
}
