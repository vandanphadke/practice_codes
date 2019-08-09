import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */
public class RemoveInvalidParanthesis {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        int left = 0, right = 0;
        for (char bracket : s.toCharArray()){
            if (bracket == '('){
                ++left;
            }
            else {
                if (left != 0){
                    --left;
                }
                else {
                    ++right;
                }
            }
        }
        return null;
    }

    public static boolean checkValidParan(String s){
        Stack<Character> bracStack = new Stack<>();
        for (char bracket : s.toCharArray()){
            if (bracket == '(')
                bracStack.push(bracket);
            else {
                if (bracStack.isEmpty()) return false;
                else bracStack.pop();
            }
        }
        return bracStack.isEmpty();
    }

    public static boolean removeParanRecurse(String s, int currentIndex,
                                          int leftRemain, int rightRemain,
                                          Set<String> results){
        if (currentIndex == s.length()){
            if (leftRemain == 0 && rightRemain == 0){
                results.add(s);
                return true;
            }
            return false;
        }
        return false;


    }
}
