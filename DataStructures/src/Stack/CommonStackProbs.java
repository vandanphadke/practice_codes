package Stack;

import java.util.Stack;

public class CommonStackProbs {

	public static boolean balancedParanthesis(String expression)
	{
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0 ; i < expression.length(); i++)
		{
			if(expression.charAt(i) == '{' || expression.charAt(i) == '[' || expression.charAt(i) == '(')
				stack.push(expression.charAt(i));
			
			else if(expression.charAt(i) == '}')
			{
				if(stack.pop() != '{')
					return false;
				else
					continue;
			}
			
			else if(expression.charAt(i) == ']')
			{
				if(stack.pop() != '[')
					return false;
				else
					continue;
			}
			
			else if(expression.charAt(i) == ')')
			{
				if(stack.pop() != '(')
					return false;
				else
					continue;
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	
	public static int evaluatePostFix(String expression)
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0 ; i < expression.length() ; i++)
		{
			System.out.println(stack.toString());
			char c = expression.charAt(i);
			if(c == '+')
			{
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op1 + op2);
			}
			
			else if(c == '-' )
			{
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op2 - op1);
			}
			
			else if(c == '*' )
			{
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op1 * op2);
			}
			
			else if(c == '/' )
			{
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op2 / op1);
			}
			
			else
			{
				stack.push((int)c - 48);
			}
		}
		
		return stack.pop(); 
	}
	
	//Sorts a stack using one extra stack
	public static Stack<Integer> sortStack(Stack<Integer> a){
		
		Stack<Integer> temp = new Stack<Integer>();
		
		while(!a.isEmpty()){
			int t = a.pop();
			
			while(!temp.isEmpty() && temp.peek() > t)
				a.push(temp.pop());
			
			temp.push(t);
		}
		return temp;
	}
}
