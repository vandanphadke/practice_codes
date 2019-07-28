package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string A representating json object. Return an array of string denoting json
 * object with proper indentation.
 *
 * Rules for proper indentation:
 *
 * Every inner brace should increase one indentation to the following lines.
 * Every close brace should decrease one indentation to the same line and the following lines.
 * The indents can be increased with an additional ‘\t’
 * Note:
 *
 * [] and {} are only acceptable braces in this case.
 *
 * Assume for this problem that space characters can be done away with.
 *
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 * Output Format
 *
 * Return a list of strings, where each entry corresponds to a single line. The strings should
 * not have "\n" character in them. For Example
 *
 * Input 1:
 *     A = "{A:"B",C:{D:"E",F:{G:"H",I:"J"}}}"
 * Output 1:
 *     {
 *         A:"B",
 *         C:
 *         {
 *             D:"E",
 *             F:
 *             {
 *                 G:"H",
 *                 I:"J"
 *             }
 *         }
 *     }
 *
 * Input 2:
 *     A = ["foo", {"bar":["baz",null,1.0,2]}]
 * Output 2:
 *    [
 *         "foo",
 *         {
 *             "bar":
 *             [
 *                 "baz",
 *                 null,
 *                 1.0,
 *                 2
 *             ]
 *         }
 *     ]
 */
public class PrettyJSON {
    public static List<String> getPrettyJSONString(String json){
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int braces = 0;
        for (char c : json.toCharArray()){
            if (c == '{' || c == '['){
                if (sb.length() != 0) {
                    result.add(String.join("", Collections.nCopies(braces, "\t")) + sb.toString());
                    sb.setLength(0);
                }
                ++braces;
                sb.append(c);
                result.add(String.join("", Collections.nCopies(braces - 1, "\t")) + sb.toString());
                sb = new StringBuilder();
            }
            else if (c == '}' || c == ']'){
                if (sb.length() != 0) {
                    result.add(String.join("", Collections.nCopies(braces, "\t")) + sb.toString());
                    sb.setLength(0);
                }
                --braces;
                sb.append(c);
            }
            else if (c == ','){
                sb.append(',');
                result.add(String.join("", Collections.nCopies(braces, "\t")) + sb.toString());
                sb = new StringBuilder();
            }
            else {
                sb.append(c);
            }
        }
        if (sb.length() != 0){
            result.add(sb.toString());
        }
        return result;
    }
}
