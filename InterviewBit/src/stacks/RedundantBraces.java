package stacks;

/**
 * Given a string of balanced expression, find if it contains a
 * redundant parenthesis or not. A set of parenthesis are redundant
 * if same sub-expression is surrounded by unnecessary or multiple brackets.
 *
 * Print ‘Yes’ if redundant else ‘No’.
 *
 * Note: Expression may contain ‘+‘, ‘*‘, ‘–‘ and ‘/‘ operators.
 * Given expression is valid and there are no white spaces present.
 *
 * Example:
 *
 * Input:
 * ((a+b))
 * (a+(b)/c)
 * (a+b*(c-d))
 * Output:
 * Yes
 * Yes
 * No
 *
 * Explanation:
 * 1. ((a+b)) can reduced to (a+b), this Redundant
 * 2. (a+(b)/c) can reduced to (a+b/c) because b is
 * surrounded by () which is redundant.
 * 3. (a+b*(c-d)) doesn't have any redundant or multiple
 * brackets.
 */

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args){
        System.out.println(checkRedundantBraces("(a+(a+b))"));
        System.out.println(checkRedundantBraces("((a+b))"));
    }

    public static int checkRedundantBraces(String expression){
        Stack<Character> exprStack = new Stack<>();
        char[] exprArr = expression.toCharArray();
        for (int i = 0; i < exprArr.length; ++i) {
            if (exprArr[i] == ')'){
                boolean checkOp = false;
                while (exprStack.peek() != '('){
                    char single = exprStack.pop();
                    if (single == '+' || single == '-' || single == '*' || single == '/')
                        checkOp = true;
                }
                exprStack.pop();
                if (!checkOp)
                    return 1;
            }
            else
                exprStack.push(exprArr[i]);
        }
        return 0;
    }
}
