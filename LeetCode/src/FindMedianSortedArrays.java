public class FindMedianSortedArrays {

    public static void main(String[] args){
        int[] A = {1,4,5};
        int[] B = {2,3};

        System.out.println(findMedianSortedArrays(A, B));

    }

    private static double findMedianSortedArrays(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;

        if (((n + m )% 2) == 0){
            return (findKthSortedArrays(arr1, 0, arr2, 0, (n+m)/2) +
                    findKthSortedArrays(arr1, 0, arr2, 0, (n+m)/2)) / 2;
        }
        else {
            return findKthSortedArrays(arr1, 0, arr2, 0, (n+m+1)/2);
        }
    }

    private static double findKthSortedArrays(int[] A, int A_start, int[] B, int B_start, int k) {
        int n = A.length - A_start;
        int m = B.length - B_start;

        if (k == 0 || (n+m) < k) return -1;
        if (n <= 0) return B[B_start + k - 1];
        if (m <= 0) return A[A_start + k - 1];
        if (k == 1) return Math.min(A[A_start], B[B_start]);
        int value1 = (k/2 <= n) ? A[A_start + (k/2) - 1]: Integer.MAX_VALUE;
        int value2 = (k/2 <= m) ? B[B_start + (k/2) - 1]: Integer.MAX_VALUE;

        if (value1 >= value2){
            return findKthSortedArrays(A, A_start, B, B_start+(k/2), k - (k/2));
        }
        else
            return findKthSortedArrays(A, A_start+(k/2) , B, B_start, k - (k/2));
    }

}
