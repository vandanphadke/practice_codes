package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**Given numRows, generate the first numRows of Pascal’s triangle.

 Pascal’s triangle : To generate A[C] in row R, sum up A’[C]
 and A’[C-1] from previous row R - 1.

 Example:

 Given numRows = 5,

 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 *
 */

public class PascalsTriangle {

    public static ArrayList<ArrayList<Integer>> generatePascalsTriangle(int n){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int current = 0;
        while (current < n){
            ArrayList<Integer> currentList = new ArrayList<>();
            int i = 0;
            while (i <= current){
                if (i == 0 || i == current){
                    currentList.add(1);
                }
                else {
                    currentList.add(result.get(current - 1).get(i-1) + result.get(current - 1).get(i));

                }
                ++i;
            }
            result.add(currentList);
            ++current;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(generatePascalsTriangle(5));
    }

}
