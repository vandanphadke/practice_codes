package LinkedList;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * If n is greater than the size of the list, remove the first node of the list.
 */
public class RemoveNthNodeList {
    class Node {
        int val;
        Node next;

        public Node(int data){
            this.val = data;
        }
    }

    public Node getEnd(Node head, int k){

        Node current = head;
        int count = 0;

        // Move a temp node k time ahead
        while (current!= null && count < k){
            ++count;
            current = current.next;
        }

        // Edge case, k > len(list)
        if (current == null)
            return head.next;


        Node current2 = head;
        while (current != null){
            current2 = current2.next;
            current = current.next;
        }

        current.next = current.next.next;
        return head;
    }

}
