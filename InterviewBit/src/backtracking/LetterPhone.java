package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * The digit 0 maps to 0 itself.
 * The digit 1 maps to 1 itself.
 *
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Make sure the returned strings are lexicographically sorted.
 *
 */
public class LetterPhone {

    public static void main(String[] args){
        System.out.println(getAllCombinations("2"));
    }

    public static ArrayList<String> getAllCombinations(String digits){
        Map<Integer, String[]> a = new HashMap<>();
        a.put(0, new String[]{"0"});
        a.put(1, new String[]{"1"});
        a.put(2, new String[]{"a", "b", "c"});
        a.put(3, new String[]{"d", "e", "f"});
        a.put(4, new String[]{"g", "h", "i"});
        a.put(5, new String[]{"j", "k", "l"});
        a.put(6, new String[]{"m", "n", "o"});
        a.put(7, new String[]{"p", "q", "r", "s"});
        a.put(8, new String[]{"t", "u", "v"});
        a.put(9, new String[]{"w", "x", "y", "z"});

        ArrayList<String> results = new ArrayList<>();
        getCombRecurse(a, "", 0, results, digits);
        return results;
    }

    public static void getCombRecurse(Map<Integer, String[]> letterMap, String current,
                               int index, ArrayList<String> results,
                               String digits){
        if (index >= digits.length()){
            results.add(current);
            return;
        }
        else {
            int num = Integer.parseInt(digits.substring(index, index + 1));
            String[] mappings = letterMap.get(num);
            for (String mapping : mappings){
                getCombRecurse(letterMap, current + mapping, index + 1, results, digits);
            }
        }
    }


}
