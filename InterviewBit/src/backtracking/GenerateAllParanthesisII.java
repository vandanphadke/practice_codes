package backtracking;

import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of
 * well-formed parentheses of length 2*n.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateAllParanthesisII {
    public static void main(String[] args){
        List<String> results = new ArrayList<>();
        Set<String> added = new HashSet<>();
        String current = "";
        generateStrings(current, 3, results, added);
        Collections.sort(results);
    }

    public static void generateStrings(String current, int n, List<String> results, Set<String> added){
        if (n == 0){
          if (!added.contains(current)){
            results.add(current);
            added.add(current);
          }
        }
        else {
            generateStrings("(" + current + ")", n-1, results, added);
            generateStrings(current + "()", n-1, results, added);
            generateStrings("()" + current, n-1, results, added);
        }
    }
}
