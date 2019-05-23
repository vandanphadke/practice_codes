package LinkedList;

/**
 * Merge two sorted linked lists
 */
public class MergeTwoSortedLists {

    class Node {
        int val;
        Node next;

        public Node(int data){
            this.val = data;
        }
    }


    public Node mergesortedlists(Node a, Node b){
        Node temp = new Node(0);
        Node head = temp;
        Node c = head;

        while ((a != null) && (b != null))
        {
            if (a.val <= b.val)
            {
                c.next = a;
                c = a;
                a = a.next;
            }
            else
            {
                c.next = b;
                c = b;
                b = b.next;
            }
        }

        c.next = ((a == null) ? b : a);
        return head.next;
    }

}
