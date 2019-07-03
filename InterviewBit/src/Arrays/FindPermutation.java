package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n and a string s consisting only of
 * letters D or I, you have to find any permutation of first n
 * positive integer that satisfy the given input string.
 *
 * D means the next number is smaller, while I means the next number is greater.
 *
 * Notes
 *
 * Length of given string s will always equal to n - 1
 * Your solution should run in linear time and space.
 * Example :
 *
 * Input 1:
 *
 * n = 3
 *
 * s = ID
 *
 * Return: [1, 3, 2]
 *
 */
public class FindPermutation {

    public static void main(String[] args){
        String str = "DIIDI";
        System.out.println(getPermutation(str, 6));
    }

    public static List<Integer> getPermutation(String A, int B){
        ArrayList<Integer> ans = new ArrayList<>();
        int max = B;
        int min = 1;

        for (char c : A.toCharArray()) {
            if (c == 'D') {
                ans.add(max);
                max--;
            }
            else {
                ans.add(min);
                min++;
            }
        }

        ans.add(min);

        return ans;
    }


}
