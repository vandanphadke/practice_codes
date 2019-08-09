package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the
 * sequence of gray code. A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * There might be multiple gray code sequences possible for a given n.
 * Return any such sequence.
 */
public class GreyCode {
    public static void main(String[] args){
        System.out.println(solve(2));
    }

    public static ArrayList<Integer> solve(int n){
        ArrayList<Integer> res = new ArrayList();
        res.add(0);
        for(int i=0;i<n;i++){
            int inc = 1 << i;
            for(int j=res.size()-1;j>=0;j--){
                res.add(res.get(j) + inc);
            }
        }
        return res;
    }
}
