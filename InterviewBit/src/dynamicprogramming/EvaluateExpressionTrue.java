package dynamicprogramming;

import java.util.Arrays;

/**
 * Given expression with operands and operators (OR , AND , XOR) , in how many ways can
 * you evaluate the expression to true, by grouping in different ways? Operands are only
 * true and false.
 * Input:
 *
 * string :  T|F&T^T
 * here '|' will represent or operator
 *      '&' will represent and operator
 *      '^' will represent xor operator
 *      'T' will represent true operand
 *      'F' will false
 * Output:
 *
 * different ways % MOD
 * where MOD = 1003
 * Example:
 *
 * string : T|F
 * only 1 way (T|F) => T
 * so output will be 1 % MOD = 1
 */
public class EvaluateExpressionTrue {
    public static void main(String[] args){
        System.out.println(getNumWays("T|F&T^T"));
        System.out.println(getNumWays("T^F&T"));
    }

    public static int getNumWays(String expression){
        int n = expression.length();
        int numVal = n / 2 + 1;
        int numExp = n - numVal;
        char[] valArr = new char[numVal];
        char[] valExp = new char[numExp];
        int a = 0, b = 0;
        for (int i = 0; i < n; ++i){
            if (i % 2 == 0){
                valArr[a] = expression.charAt(i);
                ++a;
            }
            else {
                valExp[b] = expression.charAt(i);
                ++b;
            }
        }

        int[][] dpPos = new int[numVal][numVal];
        int[][] dpNeg = new int[numVal][numVal];
        for (int i = 0; i < numVal; ++i){
            if (valArr[i] == 'T') {
                dpPos[i][i] = 1;
                dpNeg[i][i] = 0;
            }
            else {
                dpPos[i][i] = 0;
                dpNeg[i][i] = 1;
            }
        }

        for (int l = 2; l<= numVal; ++l) {
            for (int i = 0; i < numVal - l + 1; i++) {
                int j = i + l - 1;
                dpPos[i][j] = 0;
                dpNeg[i][j] = 0;
                //System.out.println(i + "  " + j);
                for (int k=i; k<=j-1; k++){
                    //System.out.println("k = " + k);
                    if (valExp[k] == '&'){
                        dpPos[i][j] += (dpPos[i][k] * dpPos[k+1][j]);
                        dpNeg[i][j] += (dpNeg[i][k] * dpNeg[k+1][j]);
                        dpNeg[i][j] += (dpPos[i][k] * dpNeg[k+1][j]);
                        dpNeg[i][j] += (dpNeg[i][k] * dpPos[k+1][j]);
                    }
                    else if (valExp[k] == '|'){
                        dpPos[i][j] += (dpPos[i][k] * dpPos[k+1][j]);
                        dpNeg[i][j] += (dpNeg[i][k] * dpNeg[k+1][j]);
                        dpPos[i][j] += (dpPos[i][k] * dpNeg[k+1][j]);
                        dpPos[i][j] += (dpNeg[i][k] * dpPos[k+1][j]);
                    }
                    else {
                        dpNeg[i][j] += (dpPos[i][k] * dpPos[k+1][j]);
                        dpNeg[i][j] += (dpNeg[i][k] * dpNeg[k+1][j]);
                        dpPos[i][j] += (dpPos[i][k] * dpNeg[k+1][j]);
                        dpPos[i][j] += (dpNeg[i][k] * dpPos[k+1][j]);
                    }
                }
            }
        }


        for (int i = 0; i < numVal; ++i){
            System.out.println(Arrays.toString(dpPos[i]));
        }
        System.out.println("-------------------------------");
        for (int i = 0; i < numVal; ++i){
            System.out.println(Arrays.toString(dpNeg[i]));
        }
        return dpPos[0][numVal-1];
    }
}
