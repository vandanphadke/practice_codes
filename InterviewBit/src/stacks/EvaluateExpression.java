package stacks;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Examples:
 *
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */
public class EvaluateExpression {

    public static int evaluate(ArrayList<String> expression){
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < expression.size(); ++i){
            if (expression.get(i).matches("-?\\d+(\\.\\d+)?")){
                numStack.push(Integer.parseInt(expression.get(i)));
            }else {
                int b = numStack.pop();
                int a = numStack.pop();
                if (expression.get(i) == "+"){
                    numStack.push(a + b);
                }
                else if (expression.get(i) == "*"){
                    numStack.push(a * b);
                }
                else if (expression.get(i) == "-"){
                    numStack.push(a - b);
                }
                else if (expression.get(i) == "/"){
                    numStack.push(a / b);
                }
            }
        }
        return numStack.peek();
    }

}
