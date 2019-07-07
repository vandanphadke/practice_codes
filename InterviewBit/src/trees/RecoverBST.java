package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Tell us the 2 values swapping which the tree will be restored.
 *
 *  Note:
 * A solution using O(n) space is pretty straight forward. Could you devise
 * a constant space solution?
 *
 * Example :
 *
 *
 * Input :
 *          1
 *         / \
 *        2   3
 *
 * Output :
 *        [1, 2]
 *
 * Explanation : Swapping 1 and 2 will change the BST to be
 *          2
 *         / \
 *        1   3
 * which is a valid BST
 */
public class RecoverBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        System.out.println(recoverBST(root));
    }


    public static ArrayList<Integer> recoverBST(TreeNode root){

        Stack<TreeNode> inorderStack = new Stack<>();
        TreeNode current = root;
        ArrayList<Integer> results = new ArrayList<>();
        TreeNode prevNode = null, curNode = null;
        TreeNode first = null , second = null;

        while (current!= null || !inorderStack.isEmpty()){

            while (current != null){
                inorderStack.push(current);
                current = current.left;
            }

            current = inorderStack.pop();
            if (curNode == null){
                curNode = current;
                prevNode = current;
            }
            else {
                prevNode = curNode;
                curNode = current;
            }

            if (curNode.val < prevNode.val){
                if (first == null && second == null){
                    first = prevNode;
                    second = curNode;
                }
                else {
                    second = prevNode;
                }
            }

            current = current.right;
        }
        results.add(first.val);
        results.add(second.val);
        return results;
    }

}
