package trees;


import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary search tree, write a function to find the kth smallest element in the tree.
 *
 * Example :
 *
 * Input :
 *   2
 *  / \
 * 1   3
 *
 * and k = 2
 *
 * Return : 2
 *
 * As 2 is the second smallest element in the tree.
 *
 */
public class KthSmallestElementInTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int getKthSmallestElement(TreeNode root, int k){
        if (root == null) return 0;

        Stack<TreeNode> recurseStack = new Stack<>();

        TreeNode current = root;

        int count = 0;
        while (current != null || !recurseStack.isEmpty()){

            while (current != null){
                recurseStack.push(current);
                current = current.left;
            }

            current = recurseStack.pop();
            ++count;

            if (count == (k - 1)){
                return current.val;
            }
            current = current.right;

        }
        return 0;
    }

}
