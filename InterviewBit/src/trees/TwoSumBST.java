package trees;

import java.util.Stack;

/**
 * Given a binary search tree T, where each node contains a positive
 * integer, and an integer K, you have to find whether or not there
 * exist two different nodes A and B such that A.value + B.value = K.
 *
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 *
 * Notes
 *
 * Your solution should run in linear time and not take memory more
 * than O(height of T).
 *
 * Assume all values in BST are distinct.
 * Example :
 *
 * Input 1:
 *
 * T :       10
 *          / \
 *         9   20
 *
 * K = 19
 *
 * Return: 1
 *
 * Input 2:
 *
 * T:        10
 *          / \
 *         9   20
 *
 * K = 40
 *
 * Return: 0
 *
 */
public class TwoSumBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static int getTwoSumBinaryTree(TreeNode root, int sum){
        if (root == null) return 0;

        Stack<TreeNode> recurseStackForward = new Stack<>();
        Stack<TreeNode> recurseStackBackward = new Stack<>();


        TreeNode current1 = root, current2 = root;
        boolean done1 = false, done2 = false;
        int val1 = 0, val2 = 0;

        while (true) {
            while (!done1){
                if (current1 != null){
                    recurseStackForward.push(current1);
                    current1 = current1.left;
                }
                else {
                    if (!recurseStackForward.isEmpty()){
                        current1 = recurseStackForward.pop();
                        val1 = current1.val;
                        current1 = current1.right;
                    }
                    done1 = true;
                }
            }


            while (!done2){
                if (current2 != null){
                    recurseStackBackward.push(current2);
                    current1 = current1.right;
                }
                else {
                    if (!recurseStackBackward.isEmpty()){
                        current2 = recurseStackBackward.pop();
                        val2 = current2.val;
                        current2 = current2.left;
                    }
                    done2 = true;
                }
            }

            if (val1 >= val2){
                return 0;
            }

            if ((val1 + val2) == sum){
                return 1;
            }
            else if ((val1 + val2) < sum){
                done1 = false;
            }
            else if ((val1 + val2) > sum){
                done2 = false;
            }
        }
    }


}
