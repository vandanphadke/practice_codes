package LinkedList;

/**
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 *     342 + 465 = 807
 * Make sure there are no trailing zeros in the output list
 * So, 7 -> 0 -> 8 -> 0 is not a valid response even though
 * the value is still 807.
 *
 */
public class AddTwoNumbersAsList {

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
        ListNode a = new ListNode(9);
        a.next = new ListNode(9);
        a.next.next = new ListNode(1);
        //a.next.next.next = new ListNode(3);

        ListNode b = new ListNode(1);
        //b.next = new ListNode(6);
        //b.next.next = new ListNode(6);

        printList(addLinkedLists(b, a));

    }

    public static void printList(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode addLinkedLists(ListNode head1, ListNode head2){
        if (head1 == null) return head2;
        if (head2 == null) return head1;


        ListNode current1 = head1;
        ListNode current2 = head2;

        int carry = 0, sum = 0;

        ListNode result = new ListNode(-1);
        ListNode resCurrent = result;

        while (current1 != null && current2 != null){
            sum = current1.val + current2.val + carry;
            if (sum >= 10){
                sum = sum - 10;
                carry = 1;
            }
            else {
                carry = 0;
            }

            resCurrent.next = new ListNode(sum);
            resCurrent = resCurrent.next;
            current1 = current1.next;
            current2 = current2.next;
        }

        if (current1 == null && current2 == null){
            if (carry == 1){
                resCurrent.next = new ListNode(1);
            }
            return result.next;
        }

        else if (current1 != null){
            while (current1 != null){
                sum = current1.val + carry;
                if (sum >= 10){
                    sum = sum - 10;
                    carry = 1;
                }
                else {
                    carry = 0;
                }
                resCurrent.next = new ListNode(sum);
                resCurrent = resCurrent.next;
                current1 = current1.next;
            }
            return result.next;
        }
        else {
            while (current2 != null){
                sum = current2.val + carry;
                if (sum >= 10){
                    sum = sum - 10;
                    carry = 1;
                }
                else {
                    carry = 0;
                }
                resCurrent.next = new ListNode(sum);
                resCurrent = resCurrent.next;
                current2 = current2.next;
            }
            return result.next;
        }
    }

}
