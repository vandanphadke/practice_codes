class BTNode {
    BTNode left;
    BTNode right;
    int val;

    public BTNode(int val){
        this.left = null;
        this.right = null;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Current Node is " + this.val;
    }
}

public class BinaryTreeCommonAncestor {

    public static void main(String[] args){
        BTNode root = new BTNode(5);
        root.right = new BTNode(10);
        root.left = new BTNode(9);
        root.left.left = new BTNode(15);
        root.left.right = new BTNode(3);
        root.right.left = new BTNode(15);
        root.right.right = new BTNode(7);


        getCommonAncestor(root, 10, 9);


    }

    private static void getCommonAncestor(BTNode root, int n1, int n2) {


    }

    public static int getCommonAncestorUtil(BTNode node, int n1, int n2){
        if (node == null) return 0;

        if (node.left.val == n1 || node.left.val == n2)
            return -1;

        if (node.right.val == n1 || node.right.val == n2)
            return 1;


        int foundLeft = getCommonAncestorUtil(node.left, n1, n2);
        int foundRight = getCommonAncestorUtil(node.right, n1, n2);

        if (foundLeft == -1 && foundRight == 1){
            System.out.println("Found");
            System.out.println(node);
            
        }

        return foundLeft;
    }


}
