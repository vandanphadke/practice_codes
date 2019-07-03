package trees;

import java.util.Stack;


/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 *
 * The first call to next() will return the smallest number in BST.
 * Calling next() again will return the next smallest number in the BST, and so on.
 *
 *  Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
 *  where h is the height of the tree.
 *
 *  Try to optimize the additional space complexity apart from the amortized time complexity.
 *
 */
public class BSTIterator {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    Stack<TreeNode> inorderStack;

    public BSTIterator(TreeNode root){
        TreeNode current = root;
        inorderStack = new Stack<>();
        while (current != null){
            inorderStack.push(current);
            current = current.left;
        }
    }

    public boolean hasNext(){
        return !inorderStack.isEmpty();
    }

    public int getNext(){
        TreeNode current = inorderStack.pop();
        int val = current.val;
        current = current.right;

        while (current != null){
            inorderStack.push(current);
            current = current.left;
        }

        return val;
    }

}
