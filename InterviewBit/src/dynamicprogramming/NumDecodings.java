package dynamicprogramming;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * Example :
 *
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 *
 */
public class NumDecodings {



    public int getDecodingWays(String str){

        int n=str.length();

        if(str==null||n==0)
            return 0;

        int dp[]=new int[n+1];
        dp[0]=1;

        if(str.charAt(0)!='0')
            dp[1]=1;

        for(int i=2;i<=n;i++)
        {
            int first=Integer.parseInt(str.substring(i-1,i));
            int second=Integer.parseInt(str.substring(i-2,i));
            if(first>=1&&first<=9)
                dp[i]+=dp[i-1];
            if(second>=10&&second<=26)
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }
}
