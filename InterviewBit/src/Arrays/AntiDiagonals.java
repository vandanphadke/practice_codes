package Arrays;

import java.util.ArrayList;

/**
 * Q:
 * Give a N*N square matrix, return an array of its anti-diagonals.
 * Look at the example for more details.
 * Input:
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * Return the following :
 *
 * [
 *   [1],
 *   [2, 4],
 *   [3, 5, 7],
 *   [6, 8],
 *   [9]
 * ]
 *
 *
 * Input :
 * 1 2
 * 3 4
 *
 * Return the following  :
 *
 * [
 *   [1],
 *   [2, 3],
 *   [4]
 * ]
 */
public class AntiDiagonals {

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(6);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(7);
        c.add(8);
        c.add(9);
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        mat.add(a);
        mat.add(b);
        mat.add(c);
        System.out.println(generateAntiDiagonals(mat));
    }

    public static ArrayList<ArrayList<Integer>>
        generateAntiDiagonals(ArrayList<ArrayList<Integer>> mat){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int rows = mat.size();
        int count = 0;
        while (count < rows){
            int i = 0, j = count;
            ArrayList<Integer> single = new ArrayList<>();
            while (j >= 0){
                single.add(mat.get(i).get(j));
                ++i;
                --j;
            }
            result.add(single);
            ++count;
        }
        --count;
        --count;
        while (count >= 0){
            int i = rows - 1 - count, j = rows - 1;
            ArrayList<Integer> single = new ArrayList<>();
            while (i < rows){
                single.add(mat.get(i).get(j));
                ++i;
                --j;
            }
            result.add(single);
            --count;
        }

        return result;

    }

}
