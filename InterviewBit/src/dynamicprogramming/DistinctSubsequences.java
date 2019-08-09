package dynamicprogramming;

/**
 * Given two sequences S, T, count number of unique ways in sequence S, to form a subsequence
 * that is identical to the sequence T.
 *
 * Subsequence : A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none ) of the characters without disturbing the relative
 * positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC"
 * is not).
 * Example :
 *
 * S = "rabbbit"
 * T = "rabbit"
 * Return 3. And the formations as follows:
 *
 * S1= "ra_bbit"
 * S2= "rab_bit"
 * S3="rabb_it"
 * "_" marks the removed character.
 */
public class DistinctSubsequences {
    public static void main(String[] args){
        System.out.println(getDistinctSub("geeksforgeeks", "ge"));
    }


    public static int getDistinctSub(String S, String T){
        int rows = T.length(), cols = S.length();
        if(rows > cols){
            return 0;
        }

        int[][] temp = new int[rows+1][cols+1];
        for(int i = 0; i <= cols; i++){
            temp[0][i] = 1;
        }

        for(int i = 1; i <= rows; i++){
            for(int j = i; j <= cols; j++){
                if(S.charAt(j-1) == T.charAt(i-1)){
                    temp[i][j] = temp[i-1][j-1] + temp[i][j-1];
                }
                else{
                    temp[i][j] = temp[i][j-1];
                }
            }
        }
        return temp[rows][cols];
    }
}
