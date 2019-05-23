public class JumpPositionsGoogle2 {

    public static void main(String[] args){
        int[] A = {10, 13, 12, 14, 15};
        boolean[] dp1 = new boolean[A.length];
        boolean[] dp2 = new boolean[A.length];

        for (int i = 0 ; i < A.length; ++i){
            canJump(i, A, true, dp1, dp2);
        }

        int count = 0;
        for (int i = 0; i < dp1.length; i++) {
            if (dp1[i])
                ++count;
        }

        System.out.println(count);
    }

    public static boolean canJump(int index, int[] A, boolean isOdd, boolean[] dp1, boolean[] dp2){
        System.out.println("Called with " + index);
        if (index == A.length - 1){
            dp1[index] = true;
            dp2[index] = true;
            return true;
        }

        if (isOdd){
            if (dp1[index] == true){
                return true;
            }

            System.out.println("1");
            int i = index;
            int greaterMin = Integer.MAX_VALUE;
            int diff = Integer.MAX_VALUE;

            for (int j = i+1; j < A.length; ++j){
                if (A[j] > A[i]){
                    if (A[j] - A[i] < diff) {
                        greaterMin = j;
                        diff = A[j] - A[i];
                    }
                }
            }

            if (greaterMin == Integer.MAX_VALUE){
                dp1[index] = false;
                return false;
            }
            else{
                dp1[index] = canJump(greaterMin, A, false, dp1, dp2);
                return dp1[index];
            }
        }
        else {
            if (dp2[index] == true)
                return true;


            System.out.println("2");
            int i = index;
            int greaterMin = Integer.MAX_VALUE;
            int diff = Integer.MAX_VALUE;
            for (int j = i+1; j < A.length; ++j){
                if (A[j] < A[i]){
                    if (A[i] - A[j] < diff) {
                        greaterMin = j;
                        diff = A[j] - A[i];
                    }
                }
            }
            if (greaterMin == Integer.MAX_VALUE){
                dp2[index] = false;
                return false;
            }
            else{
                dp2[index] = canJump(greaterMin, A, true, dp1, dp2);
                return dp2[index];
            }
        }
    }
}
