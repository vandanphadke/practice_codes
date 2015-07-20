package Trees;

public class Main {
	public static void main(String[] args) {
		BST bst = new BST(7);
		bst.insert(4);bst.insert(3);bst.insert(5);
		bst.insert(9);bst.insert(8);bst.insert(10);
		//TreeTraversals.iterativeInorder(bst.getHeadNode());
		//System.out.println();
		//bst.printInorder();
		TreeTraversals.zigzagTreeTraversal(bst.getHeadNode());
	}
}
