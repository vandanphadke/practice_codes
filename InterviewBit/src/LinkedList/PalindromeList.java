package LinkedList;


/**
 * Given a singly linked list, determine if its a palindrome.
 * Return 1 or 0 denoting if its a palindrome or not, respectively.
 *
 * Notes:
 *
 * Expected solution is linear in time and constant in space.
 * For example,
 *
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 */

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}

public class PalindromeList {
    public static int checkPalindrome(Node head){

        // Get to the middle of the list
        Node slow = head;
        Node fast = head;

        while (fast.next != null){
            fast = fast.next;
            if (fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
        }

        // In odd/even case the element with which reversing should start
        // is the next element
        Node middle = slow.next;
        Node prev = null;
        Node current = middle;
        Node next = null;

        // Reverse the second half
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        //Prev cointains pointer to reversed list
        while (prev != null){
            // Check reversed second half and first half
            if (prev.data != head.data)
                return 0;

            prev = prev.next;
            head = head.next;
        }

        return 1;
    }


    public static void main(String[] args){
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(2);
        a.next.next.next = new Node(1);
        //a.next.next.next.next = new Node(1);
        System.out.println(checkPalindrome(a));
    }

}
