package trees;

/**
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals the given sum.
 *
 * Example :
 *
 * Given the below binary tree and sum = 22,
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 */
public class PathSum {

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(checkPath(root, 39));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public static int checkPath(TreeNode root, int targetSum){
        return checkPathWithSum(root, 0, targetSum);
    }

    public static int checkPathWithSum(TreeNode root, int currentSum, int targetSum){
        if (root.left == null && root.right == null){
            if (currentSum + root.val == targetSum){
                return 1;
            }
            else
                return 0;
        }

        int left = 0;
        if (root.left != null){
            left = checkPathWithSum(root.left, currentSum + root.val, targetSum);
        }

        int right = 0;
        if (root.right != null){
            right = checkPathWithSum(root.right, currentSum + root.val, targetSum);
        }
        return Math.max(left, right);
    }
}
