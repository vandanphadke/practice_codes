package Stack;

import java.util.Stack;

/**
 * Q: Convert an infix expression to a postfix expression
 * @author Vandan Phadke
 *
 */
public class InfixToPostfix {
	

	public static void main(String[] args){
	    System.out.println(toPostfix("A*B-(C+D)+E"));
	}
	
	public static String toPostfix(String infix){
		char symbol;
		String postfix = "";
		Stack<Character> operators = new Stack<Character>();
        for(int i=0;i<infix.length();++i){
			symbol = infix.charAt(i);
			if (Character.isLetter(symbol))
				postfix = postfix + symbol;
			else if (symbol=='('){
				operators.push(symbol);
			}
			else if (symbol==')'){
				while (operators.peek() != '(')
				{
					postfix = postfix + operators.pop();
				}
				operators.pop();
			}
			else{
				while (!operators.isEmpty() && !(operators.peek()=='(') && prec(symbol) <= prec(operators.peek()))
					postfix = postfix + operators.pop();
				
				operators.push(symbol);
			}
		}
		while (!operators.isEmpty())
			postfix = postfix + operators.pop();
		return postfix;
	}
	
	
	static int prec(char x)
	{
		if (x == '+' || x == '-')
			return 1;
		if (x == '*' || x == '/' || x == '%')
			return 2;
		return 0;
	}
}
