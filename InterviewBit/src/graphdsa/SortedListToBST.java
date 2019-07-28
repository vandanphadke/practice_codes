package graphdsa;

import java.util.ArrayList;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST. A height balanced BST : a height-balanced
 * binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 * Example :
 *
 *
 * Given A : 1 -> 2 -> 3
 * A height balanced BST  :
 *
 *       2
 *     /   \
 *    1     3
 */
public class SortedListToBST {

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return this.val + " ";
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode converttoTree(ListNode a){
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(a != null){
            list.add(a.val);
            a = a.next;
        }
        return sortedListToBST(list, 0, list.size()-1);
    }

    public static TreeNode sortedListToBST(ArrayList<Integer> a, int start, int end){
        if(start > end)
            return null;
        int mid = (start + end)/2;

        TreeNode node = new TreeNode(a.get(mid));
        node.left = sortedListToBST(a, start, mid-1);
        node.right = sortedListToBST(a, mid+1, end);
        return node;
    }


}
