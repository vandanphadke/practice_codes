package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripleSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] contents1 = br.readLine().split(" ");
        String[] contents2 = br.readLine().split(" ");
        String[] contents3 = br.readLine().split(" ");

        int[] a = new int[contents1.length];
        int[] b = new int[contents2.length];
        int[] c = new int[contents3.length];

        for (int i = 0 ; i < contents1.length; ++i)
            a[i] = Integer.parseInt(contents1[i]);

        for (int i = 0 ; i < contents2.length; ++i)
            b[i] = Integer.parseInt(contents2[i]);

        for (int i = 0 ; i < contents3.length; ++i)
            c[i] = Integer.parseInt(contents3[i]);


        System.out.println(getTriplets(a, b, c));
        //System.out.println(getInflectionPoint(new int[]{1, 2, 3}, 5));
    }

    private static int getTriplets(int[] a, int[] b, int[] c) {
        Arrays.stream(a).distinct().sorted().toArray();
        Arrays.stream(b).distinct().sorted().toArray();
        Arrays.stream(c).distinct().sorted().toArray();

        int total = 0;
        for (int i = 0 ; i < b.length; ++i){
            int q = b[i];
            int no1 = getInflectionPoint(a, q);
            int no2 = getInflectionPoint(c, q);
            total += no1 * no2;

        }

        return total;
    }

    private static int getInflectionPoint(int[] arr, int no){
        int index = Arrays.binarySearch(arr, no);
        if (index <= 0)
            index = -1 - index - 1;
        return index + 1;
    }

}
