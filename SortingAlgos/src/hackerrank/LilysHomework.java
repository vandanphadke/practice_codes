package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* Q: https://www.hackerrank.com/challenges/lilys-homework/problem
*
* */
public class LilysHomework {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] line = reader.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0 ; i < n; ++i)
            arr[i] = Integer.parseInt(line[i]);

        int swapsAsc = noSwapsSelectionSortAsc(arr);
        int swapsDesc = noSwapsSelectionSortDesc(arr);
        if (swapsAsc > swapsDesc)
            System.out.println(swapsAsc);
        else
            System.out.println(swapsDesc);
    }

    public static int noSwapsSelectionSortAsc(int[] arr){
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            for (int i1 = i+1; i1 < arr.length ; ++i1){
                if (arr[i1] < arr[min_index])
                    min_index = i1;
            }
            if (min_index == i)
                continue;
            else {
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
                ++swaps;
            }

        }

        return swaps;
    }

    public static int noSwapsSelectionSortDesc(int[] arr){
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int max_index = i;
            for (int i1 = i+1; i1 < arr.length ; ++i1){
                if (arr[i1] > arr[max_index])
                    max_index = i1;
            }
            if (max_index == i)
                continue;
            else {
                int temp = arr[i];
                arr[i] = arr[max_index];
                arr[max_index] = temp;
                ++swaps;
            }

        }

        return swaps;
    }
}
