package LinkedList;

public class LlAlgos2 {
	public static void getSum(SingleLL s1, SingleLL s2){
		getSum(s1.getHead(), s2.getHead());
	}
	public static void getSum(Node l1, Node l2){
		if(l1 == null)
            System.out.println("Null");
        if(l2 == null)
        	System.out.println("Null");
            
        Node t = new Node(0);
        int carry = 0 ;
        Node p = t ; 
        while(l1 != null && l2 != null){
            
            int sum = l1.getData() + l2.getData() + carry ;
            if(sum > 10){
                sum = sum % 10;
                carry = 1 ; 
            }
            t.setNext(new Node(sum));
            t = t.getNext();
            l1 = l1.getNext();
            l2 = l2.getNext();
        }
        
        while(p.getNext() != null){
        	System.out.print(t.getData() + "  ");
        	p = p.getNext();
        }
	}
}
