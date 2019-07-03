package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes’ values.
 *
 * Example :
 * Given binary tree
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 *
 * Using recursion is not allowed.
 *
 */
public class InorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public static ArrayList<Integer> getInorderTraversal(TreeNode root){

        if (root == null) return null;

        Stack<TreeNode> recurseStack = new Stack<>();
        TreeNode current = root;
        ArrayList<Integer> results = new ArrayList<>();

        while (current != null || !recurseStack.isEmpty()){

            while (current != null){
                recurseStack.push(current);
                current = current.left;
            }

            current = recurseStack.pop();
            results.add(current.val);

            current = current.right;

        }
        return results;
    }
}
