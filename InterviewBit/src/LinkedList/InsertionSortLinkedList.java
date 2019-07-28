package LinkedList;

/**
 * Sort a linked list using insertion sort.
 *
 * We have explained Insertion Sort at Slide 7 of Arrays
 *
 * Insertion Sort Wiki has some details on Insertion Sort as well.
 *
 * Example :
 *
 * Input : 1 -> 3 -> 2
 *
 * Return 1 -> 2 -> 3
 */
public class InsertionSortLinkedList {

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
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        ListNode head2 = sortListInsertionSort(head);
        while (head2 != null){
            System.out.println(head2);
            head2 = head2.next;
        }
    }

    public static ListNode sortListInsertionSort(ListNode head){
        ListNode current = head;

        while (current.next != null){

            if (current.val <= current.next.val){
                current = current.next;
                continue;
            }
            ListNode next = current.next;
            ListNode nextNext = current.next.next;

            if (current.val <= head.val){
                next.next = head;
                head = next;
                current.next = nextNext;
            }
            else {
                ListNode current2 = head;
                while (current2.next.val < current.val){
                    current2 = current2.next;
                }
                ListNode temp = current2.next;
                current2.next = next;
                next.next = temp;
                current.next = nextNext;
            }
            //current = current.next;
        }
        return head;
    }

}
