import java.util.Arrays;

public class JumpPositionsGoogle {

    public static void main(String[] args){
        int[] A = {10, 13, 12, 14, 15};
        System.out.println(getStartingPositions(A));
    }


    public static int getStartingPositions(int[] A){
        int n = A.length;
        int[] cumulativeMin = new int[n];
        int[] cumulativeMax = new int[n];

        cumulativeMax[n-1] = n-1;
        cumulativeMin[n-1] = n-1;

        int maxNow = n-1;
        int minNow = n-1;

        for (int i = n - 2; i >= 0; --i){

            if (A[i] > A[maxNow])
                maxNow = i;

            cumulativeMax[i] = maxNow;
        }

        for (int i = n - 2; i >= 0; --i){

            if (A[i] < A[minNow])
                minNow = i;

            cumulativeMin[i] = i;
        }

        boolean[] canJump = new boolean[n];
        Arrays.fill(canJump, false);
        canJump[n-1] = true;

        for (int i = n-2; i >= 0 ; --i){
            // Odd numbered jumps
            int greaterMin = Integer.MAX_VALUE;
            int diff = Integer.MAX_VALUE;

            if (i % 2 == 1){
                System.out.println("I is 1");

            }
            else {
                System.out.println("I is 2");
                for (int j = i+1; j < n; ++j){
                    if (A[j] < A[i]){
                        if (A[i] - A[j] < diff) {
                            greaterMin = j;
                            diff = A[j] - A[i];
                        }
                    }
                }
            }

            if (greaterMin == Integer.MAX_VALUE){
                canJump[i] = false;

            }

            else{
                //System.out.println("Finally here");
                canJump[i] = canJump[greaterMin];
            }

            System.out.println("I is" + i + "  greatest is " + greaterMin );
            System.out.println(Arrays.toString(canJump));


        }

        int count = 0;
        for (int i = 0 ; i < n; ++i){
            if (canJump[i])
                ++count;
        }
        return count;
    }

}
