package LinkedList;

/**
 * Given a singly linked list
 *
 *     L: L0 → L1 → … → Ln-1 → Ln,
 *
 * reorder it to:
 *
 *     L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * You must do this in-place without altering the nodes’ values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {

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

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);

        head = getReorderedList(head);
        printList(head);


        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        //head1.next.next.next = new ListNode(4);
        //head1.next.next.next.next = new ListNode(5);

        head1 = getReorderedList(head1);
        printList(head1);

    }

    public static void printList(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode getReorderedList(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, trailSlow = head;

        // Get the middle node from the list
        while (fast!= null && fast.next != null){
            fast = fast.next.next;
            trailSlow = slow;
            slow = slow.next;
        }

        // Separate the two lists
        ListNode reverseStart = trailSlow.next;
        trailSlow.next = null;

        // Reverse the second half of the list
        reverseStart = reverse(reverseStart);

        //System.out.println("------------------");
        printList(reverseStart);
        //System.out.println("------------------");

        // merge the two lists
        ListNode start1 = head, start2 = reverseStart;

        while (start1 != null){
            ListNode temp1 = start1.next;
            ListNode temp2 = start2.next;
            start1.next = start2;
            start2.next = temp1;
            start1 = temp1;
            start2 = temp2;
        }

        if (start2 != null){
            ListNode current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = start2;
        }

        return head;
    }

    /* Function to reverse the linked list */
    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }


}
