import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q: We are given two arrays A and B of words.
 *    Each word is a string of lowercase letters.
 *
 *    Now, say that word b is a subset of word a if every letter in
 *    b occurs in a, including multiplicity.
 *
 *    For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 *
 *    Now say a word a from A is universal if for every b in B, b is a subset of a.
 *
 *    Return a list of all universal words in A.  You can return the words in any order.
 *
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bCheckCount = new int[26];
        Arrays.fill(bCheckCount, 0);
        for(String b: B){
            int[] count = charCounts(b);
            for (int i = 0 ; i < 26; ++i){
                bCheckCount[i] = Math.max(count[i], bCheckCount[i]);
            }
        }

        List<String> results = new ArrayList<>();
        for (String a: A){
            int[] aCount = charCounts(a);
            boolean flag = true;
            for (int i = 0; i < 26; ++i){
                if (aCount[i] < bCheckCount[i]){
                    flag = false;
                    break;
                }
            }
            if (flag){
                results.add(a);
            }
        }
        return results;
    }

    public int[] charCounts(String s){
        int[] count = new int[26];
        for(int i = 0; i < s.length(); ++i){
            ++count[s.charAt(i) - 'a'];
        }
        return count;
    }
}
