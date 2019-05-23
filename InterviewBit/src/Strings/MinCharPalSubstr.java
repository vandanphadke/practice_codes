package Strings;

public class MinCharPalSubstr {

    public int[] computeLps(char[] pattern){

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

    public int getMinimumCharactersForPalindrome(String s){
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        StringBuffer newString = new StringBuffer();
        newString.append(s);newString.append("!");newString.append(sb.reverse());

        int[] lps = computeLps(newString.toString().toCharArray());
        return (s.length() - lps[lps.length - 1]);
    }

}
