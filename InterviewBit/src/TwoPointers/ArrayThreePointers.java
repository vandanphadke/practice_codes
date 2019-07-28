package TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
 *
 * Find i, j, k such that :
 * max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
 *
 * **abs(x) is absolute value of x and is implemented in the following manner : **
 *
 *       if (x < 0) return -x;
 *       else return x;
 * Example :
 *
 * Input :
 *         A : [1, 4, 10]
 *         B : [2, 15, 20]
 *         C : [10, 12]
 *
 * Output : 5
 *          With 10 from A, 15 from B and 10 from C.
 */
public class ArrayThreePointers {

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(1);a.add(4);a.add(10);
        List<Integer> b = new ArrayList<>();
        b.add(2);b.add(15);b.add(20);
        List<Integer> c = new ArrayList<>();
        c.add(10);c.add(12);
        getMinDifferenceAlsoWorking(a, b, c);
        System.out.println("--------------------");
        getMinWorking(a, b, c);


    }


    public static int getMinDifferenceAlsoWorking(List<Integer> A, List<Integer> B, List<Integer> C){
        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;

        while (i < A.size() && j < B.size() && k < C.size()){
            System.out.println("Current " + i + "  " + j + "  " + k);

            int current = Math.max(Math.abs(A.get(i) - B.get(j)),
                            Math.max(Math.abs(B.get(j) - C.get(k)),
                                    Math.abs(C.get(k) - A.get(i))));

            if (current < minDiff){
                minDiff = current;
                if (minDiff == 0)
                    break;
            }
            if (current == Math.abs(A.get(i) - B.get(j))){
                if (A.get(i) < B.get(j))
                    ++i;
                else
                    ++j;
            }
            else if(current == Math.abs(B.get(j) - C.get(k))){
                if (B.get(j) < C.get(k))
                    ++j;
                else
                    ++k;
            }
            else {
                if (C.get(k) < A.get(i))
                    ++k;
                else
                    ++i;
            }
        }

        return minDiff;
    }


    public static int getMinWorking(List<Integer> a, List<Integer> b, List<Integer> c){
        int diff = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i, j, k;
        for(i = 0, j = 0, k = 0; i < a.size() && j < b.size() && k < c.size();){
            System.out.println("Current " + i + "  " + j + "  " + k);
            min = Math.min(a.get(i), Math.min(b.get(j), c.get(k)));
            max = Math.max(a.get(i), Math.max(b.get(j), c.get(k)));
            diff = Math.min(diff, max - min);
            if(diff == 0)
                break;
            if(a.get(i) == min)
                i++;
            else if(b.get(j) == min)
                j++;
            else
                k++;
        }
        return diff;

    }


}
