package hashing;

import LinkedList.AddTwoNumbersAsList;

import java.util.HashMap;

/**
 *
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or NULL.
 *
 * Return a deep copy of the list.
 *
 * Example
 *
 * Given list
 *
 *    1 -> 2 -> 3
 * with random pointers going from
 *
 *   1 -> 3
 *   2 -> 1
 *   3 -> 1
 * You should return a deep copy of the list. The returned answer
 * should not contain the same node as the original list, but a
 * copy of them. The pointers in the returned list should not link
 * to any node in the original input list.
 *
 */
public class CopyList {

    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode random;

        public ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return this.val + " ";
        }
    }

    public ListNode getListCopy(ListNode head){
        if(head == null) return null;

        HashMap<ListNode, ListNode> copyMap = new HashMap<>();

        // Create a singly linked list
        ListNode current = head;

        // Create a copy of each node
        while (current != null){
            copyMap.put(current, new ListNode(current.val));
            current = current.next;
        }

        current = head;
        while (current.next != null){
            copyMap.get(current).next = copyMap.get(current.next);
            copyMap.get(current).random = copyMap.get(current.random);
            current = current.next;
        }

        return copyMap.get(head);
    }
}
