/**
 * Implementation of the standard Knuth-Morris-Pratt Algorithm
 * for efficient substring search
 */
public class KMP {

    public static void main(String[] args){
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        boolean result = getSubstringMatches(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
    }

    public static int[] computeLps(char[] pattern){
        int i = 1, j= 0;
        int[] lps = new int[pattern.length];

        while (i < pattern.length){
            if (pattern[i] == pattern[j]){
                lps[i] = j + 1;
                ++j;
                ++i;
            }
            else {
                if (j != 0){
                    j = lps[j-1];
                }
                else {
                    lps[i] = 0;
                    ++i;
                }
            }
        }
        return lps;
    }

    public static boolean getSubstringMatches(char[] haystack, char[] needle){

        int[] lps = computeLps(needle);
        int i = 0, j = 0;
        while (i < haystack.length && j < needle.length){
            if (haystack[i] == needle[j]){
                ++i;
                ++j;
            }
            else {
                if (j != 0){
                    j = lps[j-1];
                }
                else {
                    ++i;
                }
            }
        }
        if (j == needle.length)
            return true;
        else
            return false;
    }

}