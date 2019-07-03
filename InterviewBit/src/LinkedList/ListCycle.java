package LinkedList;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle,
 * return null.
 *
 * Try solving it using constant additional space.
 *
 * Example :
 *
 * Input :
 *
 *                   ______
 *                  |     |
 *                  \/    |
 *         1 -> 2 -> 3 -> 4
 *
 * Return the node corresponding to node 3.
 *
 */
public class ListCycle {

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

    public static ListNode getCycleStartNode(ListNode head){
        if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;

        // Increment initially so that they are not equal at start
        slow = slow.next;
        fast = fast.next.next;

        while (slow != fast){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


}
