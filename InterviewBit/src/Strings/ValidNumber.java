package Strings;

/**
 * Please Note:
 * Note: It is intended for some problems to be ambiguous. You should gather all requirements up front before implementing one.
 *
 * Please think of all the corner cases and clarifications yourself.
 *
 * Validate if a given string is numeric.
 *
 * Examples:
 *
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 */
public class ValidNumber {

    public static int checkValidNumber(String numStr){
        numStr = numStr.trim();
        boolean match = numStr.matches("[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?");
        if (match) return 1;
        return 0;
    }


}
