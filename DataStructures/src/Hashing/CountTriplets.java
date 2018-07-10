package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
*   Q: You are given an array and you need to find number of tripets
*   of indices  such that the elements at those indices are in
*   geometric progression for a given common ratio  and i < j < k
*   For example arr = [1,4,16,64] and r = 4
*   we have [1,4,16] and [4,16,64] so you should return 2
* */
public class CountTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine().split(" ")[1]);
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        getTriplets(arr, r);
    }

    private static void getTriplets(int[] arr, int r) {
        List<Integer> numList = new ArrayList<>();
        for (int i: arr)
            numList.add(i);

        Collections.sort(numList);



    }
}
