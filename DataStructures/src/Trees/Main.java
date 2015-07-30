package Trees;

public class Main {
	public static void main(String[] args) {
		BST bst = new BST(7);
		bst.insert(4);bst.insert(3);bst.insert(5);
		bst.insert(9);bst.insert(8);bst.insert(10);
		//bst.printInorder();
		HorizontalSum.getHorizontalSum(bst.getHeadNode());
		System.out.println(BSTAlgos.getCeil(bst.getHeadNode(), 2));
	}
}
