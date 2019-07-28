package Math;

import java.util.ArrayList;

/**
 * Given a set of digits (A) in sorted order, find how many numbers of
 * length B are possible whose value is less than number C.
 *
 * NOTE: All numbers can only have digits from the given set.
 * Examples:
 *
 * 	Input:
 * 	  0 1 5
 * 	  1
 * 	  2
 * 	Output:
 * 	  2 (0 and 1 are possible)
 *
 * 	Input:
 * 	  0 1 2 5
 * 	  2
 * 	  21
 * 	Output:
 * 	  5 (10, 11, 12, 15, 20 are possible)
 * Constraints:
 *
 *     1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9
 */
public class NumbersLengthNLessK {

    // TODO logic
    public int getNumbers(ArrayList<Integer> A, int B, int C){
        int cSize = (int) Math.log10(C) + 1;
        int n = A.size();
        if(cSize < B || n == 0){
            return 0;
        }
        boolean zero = false;
        if(A.get(0) == 0){
            zero = true;
        }
        if(cSize > B){
            if(B > 1 && zero){
                return (n-1)* ((int)Math.pow(n, B-1));

            }
            else{
                return (int)Math.pow(n, B);
            }
        }

        int pow10 = (int) Math.pow(10, B-1);
        int count = 0;
        for(int i=B;i>0;i--){

            int target = C/pow10;
            int j=0;
            C %= pow10;
            pow10 /= 10;
            for(j=0;j<n;j++){
                if(A.get(j)>=target){
                    break;
                }
            }

            count += (B > 1 && i == B && zero ? j-1:j) * (int)Math.pow(n, i-1);
            if(j == n || A.get(j) > target)
                break;
        }

        return count;
    }
}
