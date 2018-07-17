package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ActivityNotifications2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] content = br.readLine().split(" ");
        int d = Integer.parseInt(content[1]);
        content = br.readLine().split(" ");
        int[] expenditures = new int[content.length];
        for (int i = 0; i < content.length; i++) {
            expenditures[i] = Integer.parseInt(content[i]);
        }

        System.out.println(getFraudlentActivityNotifications(expenditures, d));
    }

    private static int getFraudlentActivityNotifications(int[] expenditures, int d) {
        Queue<Integer> expendQueue = new LinkedList<>();
        int[] countArr = new int[201];
        int notif = 0;
        for (int i = 0; i < d; ++i){
            expendQueue.offer(expenditures[i]);
            countArr[expenditures[i]] = countArr[expenditures[i]] + 1;
        }

        for (int i = d; i < expenditures.length; ++i){
            if (expenditures[i] >= 2*getMedianFromCountArr(countArr, d)){
                ++notif;
            }

            int oldTran = expendQueue.poll();
            countArr[oldTran] = countArr[oldTran] - 1;

            expendQueue.offer(expenditures[i]);
            countArr[expenditures[i]] = countArr[expenditures[i]] + 1;

        }
        return notif;
    }

    public static double getMedianFromCountArr(int[] countArr, int d){
        int index = 0;
        if ((d % 2) != 0){
            int middle = d / 2;
            while(middle >= 0)
            {
                middle -= countArr[index];
                index++;
            }
            return (double) index-1;

        }
        else {
            int counter = d / 2;

            while(counter > 0)
            {
                counter -= countArr[index];
                index++;
            }
            index--;//Remove extra iteration
            if(counter <= -1)//This index covers both medians
                return index;
            else//(counter == 0) We need to find the next median index
            {
                int firstIndex = index;
                int secondIndex = index+1;
                while(countArr[secondIndex] == 0)//Find next non-zero transaction
                {
                    secondIndex++;
                }
                return (double) (firstIndex + secondIndex) / 2.0;//Calculate the average of middle two elements
            }
        }

    }
}
