package trees;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * Height-balanced binary tree : is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Example :
 *
 * Input :
 *           1
 *          / \
 *         2   3
 *
 * Return : True or 1
 *
 * Input 2 :
 *
 *          3
 *         /
 *        2
 *       /
 *      1
 *
 * Return : False or 0
 *          Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 *          Difference = 2 > 1.
 */
public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static int checkBalancedCall(TreeNode root){
        if (root == null) return 1;
        if (checkTreeBalanced(root) == -1) return 0;
        return 1;
    }

    public static int checkTreeBalanced(TreeNode root){
        int left = 0;
        if (root.left != null){
            left = checkTreeBalanced(root.left);
        }

        int right = 0;
        if (root.right != null){
            right = checkTreeBalanced(root.right);
        }

        if (left == -1 || right == -1) return -1;

        if (Math.abs(right - left) <= 1){
            return 1 + Math.max(left, right);
        }
        else
            return -1;
    }
}
