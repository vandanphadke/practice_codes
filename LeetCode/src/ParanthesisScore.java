import java.util.Stack;

/**
 *  Given a balanced parentheses string S, compute the score of the string based
 *  on the following rule:
 *
 *  () has score 1
 *  AB has score A + B, where A and B are balanced parentheses strings.
 *  (A) has score 2 * A, where A is a balanced parentheses string.
 *
 */
public class ParanthesisScore {
    public static int scoreOfParentheses(String S) {
        Stack<Integer> scoresStack = new Stack<>();
        scoresStack.push(0);

        for (int i = 0; i < S.length(); ++i){
            char bracket = S.charAt(i);
            if (bracket == '(')
                scoresStack.push(0);
            else {
                int a = scoresStack.pop();
                int b = scoresStack.pop();
                scoresStack.push(b + Math.max(2*a, 1));
            }

        }
        return scoresStack.pop();
    }
}
