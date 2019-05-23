package nutanix;

import java.util.Arrays;

public class BeautifulRow {

    public static int minNum(int[] arr, int n){
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; ++i){
            for (int j = 0; j < i; ++j){
                if (arr[i] > arr[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }

        int[] lds = new int[n];
        Arrays.fill(lds, 1);

        for (int i = n - 2; i >= 0; --i){
            for (int j = n - 1; j > i; --j){
                if (arr[i] > arr[j])
                    lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }

        int maxSequence = Integer.MIN_VALUE;
        for (int i = 0 ; i < n; ++i){
            maxSequence = Math.max(maxSequence, lis[i] + lds[i] - 1);
        }

        return n - maxSequence;

    }

}
