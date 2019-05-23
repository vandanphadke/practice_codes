package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Example :
 *
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * will result in
 *
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */

public class MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode mergeSortedLists(ArrayList<ListNode> lists){
        if (lists == null) return null;

        PriorityQueue<ListNode> nodesQueue = new PriorityQueue<ListNode>((a, b) -> {
            if (a.val > b.val)
                return 1;
            else if (a.val < b.val)
                return -1;
            else
                return 0;
        });

        for (ListNode head: lists) {
            if (head != null)
                nodesQueue.add(head);
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!nodesQueue.isEmpty()){
            ListNode minNode = nodesQueue.poll();
            current.next = minNode;
            current = current.next;
            if (minNode.next != null){
                nodesQueue.add(minNode.next);
            }
        }

        return head.next;
    }
}
