package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActivityNotifications {

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
        int n = expenditures.length;
        int notifications = 0;
        for (int i=1; i<n; ++i)
        {
            int key = expenditures[i];
            int j = i-1;

            if( i >= d){
                double currentMedian = getMedian(expenditures, (i-d),  j);
                if (key >= 2*currentMedian)
                    ++notifications;

            }

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && expenditures[j] > key)
            {
                expenditures[j+1] = expenditures[j];
                j = j-1;
            }
            expenditures[j+1] = key;
        }

        return notifications;
    }

    private static double getMedian(int[] numArray, int startIndex, int endIndex){
        int arraySize = endIndex - startIndex + 1;
        if ((arraySize % 2) != 0){
            int mid = startIndex + (arraySize/2);
            return (double) numArray[mid];
        }
        else {
            int mid = startIndex + (arraySize/2);
            return ((double)numArray[mid] + (double)numArray[mid-1])/2;
        }
    }

}
