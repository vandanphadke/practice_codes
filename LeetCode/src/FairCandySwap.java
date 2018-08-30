import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
	public static void main(String[] args) {
        int[] A = new int[]{1, 1};
        int[] B = new int[]{2, 2};

        System.out.println(fairCandySwap(A, B));
	}

    public static int[] fairCandySwap(int[] A, int[] B) {
        int Asum = 0;
        int Bsum = 0;

        for(int i = 0 ; i < A.length; ++i)
            Asum = Asum + A[i];

        for(int j = 0 ; j < B.length; ++j)
            Bsum = Bsum + B[j];

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;

        while(i < A.length && j < B.length){
            int tempA = Asum - A[i] + B[j];
            int tempB = Bsum + A[i] - B[j];

            if (tempA == tempB)
                break;
            else if (tempA > tempB)
                ++i;
            else
                ++j;

        }

        return new int[]{A[i], B[j]};
    }
}
