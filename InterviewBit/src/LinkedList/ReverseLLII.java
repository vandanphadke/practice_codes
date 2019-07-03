package LinkedList;

public class ReverseLLII {

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

    public static ListNode removeList(ListNode head, int m, int n){

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        int rem = n - m;
        ListNode current = fakeHead;

        // Increment pointer till previous node of the one to be
        // reversed
        for (int i = 0; i < m - 1; ++i) current = current.next;

        // Holds the pointer to where the first part
        // should be
        ListNode start = current;

        for (int i = 0; i <= rem; ++i){
            current = current.next;
        }

        // Holds the pointer to where the reversed part
        // should be reattached to the list
        ListNode end = current.next;
        current.next = null;

        ListNode prev = null;
        ListNode curr = start.next;
        ListNode next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        start.next = prev;
        curr = start;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = end;

        return fakeHead.next;
    }

    public static void printList(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current);
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
        printList(head);
        head = removeList(head, 2, 4);
        printList(head);
    }

}
