package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Q: https://www.hackerrank.com/challenges/countingsort4/problem
Test:
5
1 or
2 not
4 is
2 to
4 the

*?
 */
public class FullCountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        //Creating two input arrays
        int[] nos = new int[n];
        String[] words = new String[n];

        for(int i = 0 ; i < n ; ++i){
            String line = reader.readLine();
            String[] contents = line.split(" ");
            nos[i] = Integer.parseInt(contents[0]);
            words[i] = contents[1];
        }

        int arrMin = getMinimum(nos);
        int arrMax = getMaximum(nos);

        //Create count array
        int[] countArr = new int[arrMax - arrMin + 1];

        //Set frequencies
        for (int i = 0; i < nos.length; i++)
            ++countArr[nos[i] - arrMin];

        //Add previous element
        for (int i = 1; i < countArr.length; i++)
            countArr[i] = countArr[i-1] + countArr[i];

        String[] sortedWords = new String[n];
        String replacer;
        for (int i = n-1; i >= 0; --i) {
            if (i < n/2) {
                replacer = "-";
            }
            else {
                replacer = words[i];
            }
            sortedWords[countArr[nos[i] - arrMin] - 1] = replacer;
            --countArr[nos[i] - arrMin];
        }

        StringBuilder sb = new StringBuilder();
        if (sortedWords.length >= 1) {
            sb.append(sortedWords[0]);
        }

        for (int i = 1; i < sortedWords.length; i++) {
            sb.append(" " + sortedWords[i]);
        }

        System.out.println(sb.toString());
    }

    public static int getMinimum(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i: arr)
            if (i < min)
                min = i;
        return min;
    }

    public static int getMaximum(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i: arr)
            if (i > max)
                max = i;
        return max;
    }

}
