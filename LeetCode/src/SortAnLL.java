class ListNode {

    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }

}

public class SortAnLL {

    public ListNode sortList(ListNode A) {
        return mergeSortLL(A);
    }

    public ListNode mergeSortLL(ListNode start){
        if (start == null || start.next == null)
            return start;

        ListNode mid = middleLL(start);
        ListNode left = mergeSortLL(start);
        ListNode nextMid = mid.next;
        mid.next = null;
        ListNode right = mergeSortLL(nextMid);
        return mergeSortedLL(left, right);
    }

    public ListNode mergeSortedLL(ListNode start1, ListNode start2){

        ListNode res = null;

        if (start1 == null)
            return start2;
        if (start2 == null)
            return start1;

        if (start1.val <= start2.val)
        {
            res = start1;
            res.next = mergeSortedLL(start1.next, start2);
        }
        else
        {
            res = start2;
            res.next = mergeSortedLL(start1, start2.next);
        }
        return res;


    }

    public ListNode middleLL(ListNode start){
        ListNode slow = start;
        ListNode fast = start;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

}
