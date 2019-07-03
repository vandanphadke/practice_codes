package LinkedList;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 *
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 */
public class RotateList {

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode removeList(ListNode head, int k){
        int n = getListSize(head);

        if (k % n == 0)
            return head;

        int moveAhead = n - (k % n);
        System.out.println(moveAhead);
        ListNode current = head;

        for (int i = 0; i < moveAhead - 1; ++i)
            current = current.next;


        ListNode newHead = current.next;
        current.next = null;

        current = newHead;

        while (current.next != null)
            current = current.next;

        current.next = head;

        return newHead;
    }

    public static int getListSize(ListNode head){
        ListNode current = head;
        int size = 0;

        while(current != null){
            ++size;
            current = current.next;
        }
        return size;
    }

    public static void printList(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val + "  ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(getListSize(head));
        printList(head);
        ListNode newhead = removeList(head, 2);
        printList(newhead);
    }

}
