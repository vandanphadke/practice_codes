package LinkedList;

/**
 * Given a sorted linked list,
 * delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */


public class RemoveDuplicatesSortedListII {

    class Node {
        int val;
        Node next;

        public Node(int data){
            this.val = data;
        }
    }

    public Node remove(Node head){
        if(head == null)
            return null;

        // Add a dummy node to the start of a linked list
        Node dummy = new Node(0);
        Node current = head;

        Node prev = dummy;
        dummy.next = head;
        current = head;


        while(current != null){
            while (current.next != null && prev.next.val == current.next.val)
                current = current.next;

            if(prev.next == current)
                prev = prev.next;

            else
                prev.next = current.next;

            current = current.next;
        }

        return dummy.next;

    }

}
