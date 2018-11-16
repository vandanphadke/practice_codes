import java.util.Arrays;

/**
 *  Given an array of n integers where each value represents
 *  number of chocolates in a packet. Each packet can have variable number of chocolates.
 *  There are m students, the task is to distribute chocolate packets such that:
 *
 *  Each student gets one packet.
 *  The difference between the number of chocolates in packet with maximum chocolates and packet with
 *  minimum chocolates given to the students is minimum.
 *
 */
public class ChocolateDistribution {

    public static void main(String[] args){

        int[] packets =  {12, 4, 7, 9, 2, 23, 25, 41,
                30, 40, 28, 42, 30, 44, 48,
                43, 50};

        int m = 7;

        System.out.println(distributeChocolates(packets, m));
    }

    private static int distributeChocolates(int[] packets, int m) {

        Arrays.sort(packets);

        int minDiff = Integer.MAX_VALUE;
        int maxStart = 0, maxEnd = 0;
        for (int i = 0; i + m - 1 < packets.length; ++i){
            int diff = packets[i + m - 1] - packets[i];
            if (diff < minDiff){
                maxStart = i;
                maxEnd = i + m - 1;
                minDiff = diff;
            }
        }

        for (int i = maxStart; i <= maxEnd; i++) {
            System.out.print(packets[i] + " ");
        }
        System.out.println();
        return minDiff;

    }



}
