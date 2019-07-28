package hashing;

import java.util.*;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length.
 *
 * Find all starting indices of substring(s) in S that is a concatenation of each word
 * in L exactly once and without any intervening characters.
 *
 * Example :
 *
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringConcatenation {

    public static void main(String[] args){
        String s = "abcdababcd";
        List<String> subs = Arrays.asList("ab", "ab");
        System.out.println(returnIndices(s, subs));
    }

    public static ArrayList<Integer> returnIndices(String s, List<String> subs){
        Map<String, Integer> substrCount = new HashMap<>();
        ArrayList<Integer> results = new ArrayList<>();
        for (String subStr : subs){
            substrCount.put(subStr, substrCount.getOrDefault(subStr, 0) + 1);
        }

        int k = subs.get(0).length();
        int totalSize = k * subs.size();

        if (totalSize > s.length()){
            return new ArrayList<>();
        }

        for (int i = 0; i <= s.length() - totalSize; ++i){
            Map<String, Integer> current = copyMap(substrCount);
            for (int j = 0; j < totalSize; j = j + k){
                String sub = s.substring(i + j, i + j + k);
                if (current.getOrDefault(sub, 0) > 0){
                    current.put(sub, current.get(sub) - 1);
                    if (current.get(sub) == 0)
                        current.remove(sub);
                }
                else {
                    break;
                }
            }
            if (current.isEmpty()){
                results.add(i);
            }
        }

        return results;
    }

    public static Map<String, Integer> copyMap(Map<String, Integer> map){
        Map<String, Integer> copy = new HashMap<>();
        for (String key : map.keySet()){
            copy.put(key, map.get(key));
        }
        return copy;
    }

}
