package Trees;

public class Main {
	public static void main(String[] args) {
		BST bst = new BST(7);
		bst.insert(4);bst.insert(3);bst.insert(5);
		bst.insert(9);bst.insert(8);bst.insert(10);
		System.out.println(BSTAlgos.lca(bst.getHeadNode(), 10, 5));
		System.out.println();
	}
}
