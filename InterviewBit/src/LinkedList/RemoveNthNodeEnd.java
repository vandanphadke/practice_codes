package LinkedList;

public class RemoveNthNodeEnd {

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode a, int b) {
        if (a == null)
            return null;

        ListNode fast = a;
        ListNode slow = a;

        for (int i = 0; i < b; i++) {

            fast = fast.next;

            // if remove the first node
            if (fast == null) {
                a = a.next;
                return a;
            }

        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return a;
    }

}
