package GeeksForGeeks;

public class InterleavingStrings {

    public static void main(String[] args){

        isInterleaved("XXY", "XXZ", "XXZXXXY");
        isInterleaved("XY" ,"WZ" ,"WZXY");
        isInterleaved("XY", "X", "XXY");
        isInterleaved("YX", "X", "XXY");
        isInterleaved("XXY", "XXZ", "XXXXZY");
    }

    private static boolean isInterleaved(String A, String B, String C) {
        boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;

                else if (i == 0 && C.charAt(j-1) == B.charAt(j - 1))
                    dp[i][j] = dp[i][j-1];

                else if (j == 0 && C.charAt(i-1) == A.charAt(i - 1))
                    dp[i][j] = dp[i-1][j];


                else if (C.charAt(i + j - 1) == A.charAt(i-1) && C.charAt(i + j - 1) != B.charAt(j - 1))
                    dp[i][j] = dp[i-1][j] ;


                else if (C.charAt(i + j - 1) != A.charAt(i-1) && C.charAt(i + j - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i][j-1] ;

                else if (C.charAt(i + j - 1) == A.charAt(i-1) && C.charAt(i + j - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];

            }
        }

        return dp[A.length()][B.length()];
    }


}
