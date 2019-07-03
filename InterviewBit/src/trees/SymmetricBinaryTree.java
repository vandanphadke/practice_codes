package trees;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie,
 * symmetric around its center).
 *
 * Example :
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * The above binary tree is symmetric.
 * But the following is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class SymmetricBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int checkSymmetricTree(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) return 1;
        if (root1 == null || root2 == null) return 0;

        if (root1.val != root2.val) return 0;

        return Math.min(checkSymmetricTree(root1.left, root2.right),
                checkSymmetricTree(root1.right, root2.left));
    }

}
