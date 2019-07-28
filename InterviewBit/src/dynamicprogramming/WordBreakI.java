package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 *
 * For example, given
 *
 * s = "myinterviewtrainer",
 * dict = ["trainer", "my", "interview"].
 * Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as
 * "my interview trainer".
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class WordBreakI {
    public static void main(String[] args){
        String s = "myinterviewtrainer";
        Set<String> dict = new HashSet<>();
        dict.add("trainer");
        dict.add("my");
        dict.add("interview");
        System.out.println(wordbreak(s, dict));
    }

    public static int wordbreak(String s, Set<String> dictionary){
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; ++i){
            if (dictionary.contains(s.substring(0, i+1))){
                dp[i] = true;
            }
            for (int j = 0; j < i; ++j){
                if (dp[j] && dictionary.contains(s.substring(j+1, i+1))){
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1] ? 1 : 0;
    }

    public static boolean wordBreakAnother(String s, ArrayList<String> dict){
        boolean[] t = new boolean[s.length()+1];
        t[0] = true;

        for(int i=0; i<s.length(); i++){
            if(!t[i])
                continue;

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }
}
