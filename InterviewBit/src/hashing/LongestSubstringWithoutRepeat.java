package hashing;

import java.util.HashMap;

/**
 * Given a string,
 * find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * The longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3.
 *
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeat {

    public static void main(String[] args){
        System.out.println(longestLengthSub("abcdabcdbb"));
        System.out.println(longestLengthSub("bbbbb"));
        System.out.println(longestLengthSub("abcdefgh"));
    }


    public static int longestLengthSub(String s){
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxlength = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (j < s.length()){
            if (!charIndexMap.containsKey(s.charAt(j))){
                charIndexMap.put(s.charAt(j), j);
                ++j;
            }
            else {
                int k = charIndexMap.get(s.charAt(j));
                while (i <= k){
                    charIndexMap.remove(s.charAt(i));
                    ++i;
                }
            }
            if (maxlength < charIndexMap.size())
                maxlength = charIndexMap.size();
        }
        return maxlength;
    }
}
