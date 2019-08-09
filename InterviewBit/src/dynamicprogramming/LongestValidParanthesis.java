package dynamicprogramming;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the
 * length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()",
 * which has length = 4.
 */
public class LongestValidParanthesis {


    public static void main(String[] args){
        System.out.println(getLengthLongestParanthesis("(()"));
        System.out.println(getLengthLongestParanthesis(")()())"));
        System.out.println(getLengthLongestParanthesis("))(("));
    }

    public static int getLengthLongestParanthesis(String brackets){
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(')
                ++left;
            else
                ++right;

            if (left == right){
                if (max < left){
                    max = left;
                }
            }
            else if (right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = brackets.length() - 1; i >= 0; --i) {
            if (brackets.charAt(i) == '(')
                ++left;
            else
                ++right;

            if (left == right){
                if (max < left){
                    max = left;
                }
            }
            else if (right < left){
                left = right = 0;
            }
        }
        System.out.println(max);
        return 2*max;
    }

    public static int getValidParanthesisStack(String brackets){
        int max = 0;
        Stack<Integer> bracStacks = new Stack<>();
        bracStacks.push(-1);

        for (int i = 0; i < brackets.length(); ++i){
            if (brackets.charAt(i) == '('){
                bracStacks.push(i);
            }
            else {
                bracStacks.pop();
                if (bracStacks.isEmpty()){
                    bracStacks.push(i);
                }
                else {
                    max = Math.max(max, i - bracStacks.peek());
                }
            }
        }
        return max;
    }

}
