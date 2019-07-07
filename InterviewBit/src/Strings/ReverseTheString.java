package Strings;

/**
 *
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Given s = "the sky is blue",
 *
 * return "blue is sky the".
 *
 * A sequence of non-space characters constitutes a word.
 * Your reversed string should not contain leading or trailing spaces,
 * even if it is present in the input string.
 * If there are multiple spaces between words, reduce them to a single
 * space in the reversed string.
 *
 */
public class ReverseTheString {

    public String reverse(String s){
        String[] strArr = s.trim().split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; --i){
            sb.append(strArr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
