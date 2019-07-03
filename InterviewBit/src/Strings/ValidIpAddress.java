package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a string containing only digits, restore it by returning all
 * possible valid IP address combinations.
 *
 * A valid IP address must be in the form of A.B.C.D, where
 * A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed
 * unless they are 0.
 *
 * Example:
 *
 * Given “25525511135”,
 *
 * return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned
 * strings are sorted in order)
 *
 */
public class ValidIpAddress {

    public static void main(String[] args){
        System.out.println(getValidIpCombinations("2552551110"));
    }

    public static ArrayList<String> getValidIpCombinations(String ipStr){
        ArrayList<String> results = new ArrayList<>();
        for (int i = 1; i <= 3; ++i){
            for (int j = i + 1; j <= i + 3; ++j){
                for (int k = j + 1; k <= j + 3; ++k){

                    if (k >= ipStr.length())
                        continue;

                    String s1 = ipStr.substring(0, i);
                    String s2 = ipStr.substring(i, j);
                    String s3 = ipStr.substring(j, k);
                    String s4 = ipStr.substring(k);

                    if (isStrValidNum(s1) && isStrValidNum(s2) &&
                            isStrValidNum(s3) && isStrValidNum(s4)){
                        results.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }

        return results;
    }

    public static boolean isStrValidNum(String numStr){
        if (numStr.equals("0") ||
                ((numStr.charAt(0) != '0') && (Integer.parseInt(numStr) <= 255)))
            return true;

        return false;
    }


}
