package trees;

import com.sun.source.tree.Tree;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a
 * number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers % 1003.
 *
 * Example :
 *
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
 */
public class SumRoottoLeafNumbers {
    public static final int MOD = 1003;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int sumNumbers(TreeNode root) {
        return sum(root, 0)%MOD;
    }

    public int sum(TreeNode root, int mul) {

        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return (mul*10 + root.val)%1003;
        }

        int num = mul*10 + root.val;
        num %= 1003;
        int ans = (sum(root.left, num) + sum(root.right, num));

        return ans%MOD;
    }
}
