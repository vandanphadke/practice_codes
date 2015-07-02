import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0){
			infixToPostfix(in.readLine());
		}
		
	}
	
	public static void infixToPostfix(String expression){
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i < expression.length() ; i++){
			char c = expression.charAt(i) ; 
			if(Character.isDigit(c))
				System.out.print(c);
			else if(c == '(')
				stack.push(c);
			else if(c == ')'){
				while(!stack.isEmpty() && stack.peek() != '(')
					System.out.print(stack.pop());
				if(!stack.isEmpty() && stack.peek() != '(')
					return; 
				else
					while(!stack.isEmpty())
						stack.pop();
			}
			else{
				while(!stack.isEmpty() && (getPrecedence(c) <= getPrecedence(stack.peek())))
					System.out.print(stack.pop());
				stack.push(c);
			}
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop());
	}
	
	public static int getPrecedence(char c){
		switch (c) {
		case '+':
		case '-':
			return 1 ;
		case '*':
		case '/':
			return 2 ;
		default:
			return 0 ; 
		}
	}
}