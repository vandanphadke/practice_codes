package trees;

import com.sun.source.tree.Tree;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * Example :
 * Given
 *
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 *
 * The flattened tree should look like:
 *
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Note that the left child of all nodes should be NULL.
 */
public class FlattenBTToLL {
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        TreeNode root2 = flattenToLL(root);
        while (root2 != null){
            System.out.println(root2.val);
            root2 = root2.right;
        }

    }

    public static TreeNode flattenToLL(TreeNode root){
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode current = root;
        while (current != null || !nodeStack.isEmpty()){

            if (current.right != null){
                nodeStack.push(current.right);
            }

            current.right = current.left;
            current.left = null;

            if (current.right == null && !nodeStack.isEmpty()){
                current.right = nodeStack.pop();
            }

            current = current.right;
        }
        return root;
    }
}
