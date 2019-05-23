package Arrays;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal’s triangle.
 *
 * Pascal’s triangle : To generate A[C] in row R,
 * sum up A’[C] and A’[C-1] from previous row R - 1.
 *
 */
public class PascalsTriangleKthRow {

    public static ArrayList<Integer> getKthRowPascalsTriangle(int k){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        int count = 1;
        int total = 1;
        while (count < k){
            total = total * (k - count)/count;
            result.add(total);
            ++count;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(getKthRowPascalsTriangle(6));
    }
}
