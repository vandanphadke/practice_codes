package Arrays;

import java.util.ArrayList;
import java.util.Stack;

/**
 * You are given an array A containing N integers. The special product of
 * each ith integer in this array is defined as the product of the following:
 *
 * LeftSpecialValue: For an index i, it is defined as the index
 * j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in
 * multiple positions, the LeftSpecialValue is the maximum value of j.
 *
 * RightSpecialValue: For an index i, it is defined as the index j such
 * that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions,
 * the RightSpecialValue is the minimum value of j.
 *
 * Write a program to find the maximum special product of any integer in the array.
 *
 * Input: You will receive array of integers as argument to function.
 *
 * Return: Maximum special product of any integer in the array modulo 1000000007.
 *
 * Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.
 *
 * Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9
 */
public class MAXSPPROD {

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);arr.add(7);arr.add(2);
        arr.add(11);arr.add(4);arr.add(7);arr.add(9);

        getMaximumProduct(arr);
    }

    public static int getMaximumProduct(ArrayList<Integer> arr){
        int n = arr.size();
        final int MOD = 1000000007;

        int[] lsv = new int[n];
        lsv[0] = 0;
        Stack<Integer> leftStack = new Stack<>();
        leftStack.push(0);

        for (int i = 1; i < n; ++i){
            int top = leftStack.peek();
            if (arr.get(top) > arr.get(i)){
                lsv[i] = top;
                leftStack.push(i);
            }
            else {
                while (!leftStack.isEmpty()){
                    top = leftStack.peek();
                    if (arr.get(top) <= arr.get(i)){
                        leftStack.pop();
                    }
                    else
                        break;
                }

                if (leftStack.isEmpty()){
                    lsv[i] = 0;
                    leftStack.push(i);
                }
                else {
                    lsv[i] = top;
                    leftStack.push(i);
                }
            }
        }

        int[] rsv = new int[n];
        rsv[n-1] = 0;

        Stack<Integer> rightStack = new Stack<>();
        rightStack.push(n-1);

        for (int i = n-2; i >= 0; --i){
            int top = rightStack.peek();
            if (arr.get(top) > arr.get(i)){
                rsv[i] = top;
                rightStack.push(i);
            }
            else {
                while (!rightStack.isEmpty()){
                    top = rightStack.peek();
                    if (arr.get(top) <= arr.get(i)){
                        rightStack.pop();
                    }
                    else
                        break;
                }

                if (rightStack.isEmpty()){
                    rsv[i] = 0;
                    rightStack.push(i);
                }
                else {
                    rsv[i] = top;
                    rightStack.push(i);
                }
            }
        }

        long product=0, res= 0;

        for(int i = 0; i< n ; ++i){
            res= (long)lsv[i] * (long)rsv[i];
            if(product < res){
                product  = res;
            }
        }

        return (int)(product%1000000007);
    }
}
