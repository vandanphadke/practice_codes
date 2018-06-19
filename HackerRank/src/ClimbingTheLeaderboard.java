import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
*
* Problem in brief:
* Print out the leaderboard score for alice, all the scores
* and monotonically increasing scores for alice are given
* */

public class ClimbingTheLeaderboard {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] ranks = new int[scores.length];
        ranks[0] = 1;
        int currentRank = 1;
        for(int i = 1 ; i < scores.length; ++i){
            if(scores[i] != scores[i-1])
                ++currentRank;
            ranks[i] = currentRank;
        }

        int i = 0 ;
        int j = ranks.length - 1;
        while(alice[i] < scores[scores.length - 1] && i < alice.length && j >= 0){
            alice[i] = ranks[scores.length - 1] + 1;
            ++i;
        }

        while(alice[i] < scores[0] && i < alice.length && j >= 0){
            while(alice[i] >= scores[j]){
                --j;

            }
            if(alice[i] == scores[j])
                alice[i] = ranks[j];
            else
                alice[i] = ranks[j] + 1;
            ++i;
        }

        while(i < alice.length && j >= 0){
            alice[i] = 1;
            ++i;
        }

        while(i < alice.length){
            alice[i] = 1;
            ++i;
        }


        return alice;
    }

}
