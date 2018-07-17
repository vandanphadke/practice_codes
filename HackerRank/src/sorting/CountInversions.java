package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Question: https://www.hackerrank.com/challenges/ctci-merge-sort/problem
 * n an array, , the elements at indices i and  j (where i < j) form an inversion if a[i] > a[j].
 *
 * In other words, inverted elements  a[i] and  a[j] are considered to be "out of order".
 * To correct an inversion, we can swap adjacent elements.
 *
 * Given  datasets, print the number of inversions that must be swapped to sort each dataset on a new line.
 *
 * Solution:
 * Here we will be using a modification of the merge sort algorithm
 * We will count inversions while merging the arrays
 */
public class CountInversions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());


        for (int i = 0 ; i < d ; ++i){
            br.readLine();
            String[] content = br.readLine().split(" ");
            int[] nos = new int[content.length];
            for (int j = 0 ; j < content.length; ++j){
                nos[j] = Integer.parseInt(content[j]);
            }

            System.out.println(countInversions(nos));
        }

    }

    private static long countInversions(int[] nos) {
        int temp[] = new int[nos.length];
        return mergeSort(nos, temp, 0, nos.length - 1);
    }

    private static long mergeSort(int[] nos, int[] temp, int l, int r) {

        long totalInversions = 0;

        if (l < r){
            int mid = (l+r)/2;

            totalInversions = mergeSort(nos, temp, l, mid);
            totalInversions += mergeSort(nos, temp, mid+1, r);

            totalInversions += merge(nos, temp, l, mid+1, r);
        }

        return totalInversions;
    }

    private static long merge(int[] nos, int[] temp, int l, int mid, int r) {

        int i = l, j = mid, k = l;
        int inversionCount = 0;

        while (i <= mid-1 && j <= r){
            if (nos[i] <= nos[j]){
                temp[k] = nos[i];
                ++k;
                ++i;
            }
            else {
                temp[k] = nos[j];
                ++k;
                ++j;
                inversionCount += (mid - i);
            }
        }

        while(i <= mid-1){
            temp[k] = nos[i];
            ++k;
            ++i;
        }

        while (j <= r){
            temp[k] = nos[j];
            ++k;
            ++j;
        }

        for (int x = l; x <= r; x++)
            nos[x] = temp[x];

        return inversionCount;

    }

}
