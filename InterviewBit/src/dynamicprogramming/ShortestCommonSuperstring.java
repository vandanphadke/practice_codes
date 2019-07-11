package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of strings. Find the length of smallest string which
 * has all the strings in the set as substring
 *
 * Constraints:
 * 1) 1 <= Number of strings <= 18
 * 2) Length of any string in the set will not exceed 100.
 *
 * Example:
 * Input: [“abcd”, “cdef”, “fgh”, “de”]
 * Output: 8 (Shortest string: “abcdefgh”)
 */
public class ShortestCommonSuperstring {


    public static void main(String[] args){
        List<String> strs = new ArrayList<>();
        strs.add("catgc");strs.add("ctaagt");strs.add("gcta");strs.add("ttca");
        strs.add("atgcatc");
        System.out.println(getSuperString(strs));
    }


    public static String getSuperString(List<String> strings){
        while (strings.size() != 1){
            int minLength = Integer.MAX_VALUE;
            String minStr = "";
            int minI = 0, minJ = 1;

            for (int i = 0; i < strings.size(); ++i){
                for (int j = 1; j < strings.size(); ++j){
                    if (i == j) continue;
                    String superStr = getMinSuperString(strings.get(i), strings.get(j));
                    if (superStr.length() < minLength){
                        minLength = superStr.length();
                        minStr = superStr;
                        minI = i;
                        minJ = j;
                    }
                }
            }
            if (minStr.equals(""))
                break;

            List<String> removeStrs = new ArrayList<>();
            removeStrs.add(strings.get(minI));
            removeStrs.add(strings.get(minJ));
            strings.removeAll(removeStrs);
            strings.add(minStr);
        }
        return strings.get(0);
    }

    public static String getMinSuperString(String s1, String s2){
        int n1 = s1.length(), n2 = s2.length();
        int l = Math.min(n1, n2);
        while (l > 0){
            if (s1.substring(n1 - l, n1).equals(s2.substring(0, l))){
                return s1.substring(0, n1-l) +
                        s2;
            }
            else if (s1.substring(0, l).equals(s2.substring(n2 - l, n2))){
                return s2.substring(0, n2-l) +
                        s1;
            }
            --l;
        }
        return s1 + s2;
    }

}
