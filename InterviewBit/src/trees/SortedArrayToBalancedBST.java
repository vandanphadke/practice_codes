package trees;

import java.util.List;

/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * Balanced tree : a height-balanced binary tree is defined as a
 * binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 *
 * Example :
 *
 *
 * Given A : [1, 2, 3]
 * A height balanced BST  :
 *
 *       2
 *     /   \
 *    1     3
 */
public class SortedArrayToBalancedBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildBSTCall(List<Integer> arr){
        return buildBST(arr, 0, arr.size() - 1);
    }


    public TreeNode buildBST(List<Integer> sortedArr, int start, int end){
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sortedArr.get(mid));
        root.left = buildBST(sortedArr, start, mid - 1);
        root.right = buildBST(sortedArr, mid + 1, end);
        return root;
    }

}
