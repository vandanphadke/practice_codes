package Stack;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		//StackLL stack = new StackLL(10);
		
		/*Stack<Integer> stack = new Stack<Integer>();
		stack.push(20);stack.push(10);stack.push(30);stack.push(50);
		stack = CommonStackProbs.sortStack(stack);
		System.out.println(stack);
		try {
			stack.push(20);stack.push(30);
			stack.linkedlist.printList();
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			//System.out.println(CommonStackProbs.evaluatePostFix("23+68-*"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		CommonStackProbs.infixToPostfix("8+9*4");
	}
}
