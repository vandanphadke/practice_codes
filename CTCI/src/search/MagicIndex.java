package search;

/**
 * In a given array A[i], find an index i such that A[i] == i
 *
 * Write two functions, assuming distinct and non-distinct numbers
 *
 */
public class MagicIndex {

    /*
    *  Modified Binary Search
    * */
    public static int getMagicIndexDistict(int[] arr){
        int i = 0, j = arr.length - 1;
        while (i <= j){
            int mid = (j - i) / 2;
            if (arr[mid] == mid){
                return mid;
            }
            else if (arr[mid] > mid){
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }
        return 0;
    }

    public static int getMagicIndexNonDistinct(int[] arr, int l, int r){
        if (r < l) return -1;

        int mid = (l + r) / 2;
        int midVal = arr[mid];

        if (mid == midVal)
            return mid;

        // Search the left side
        int left = getMagicIndexNonDistinct(arr, l, Math.min(mid - 1, midVal));
        if (left >= 0)
            return left;

        // Search the right side
        int right = getMagicIndexNonDistinct(arr, Math.max(mid + 1, midVal), r);
        if (right >= 0)
            return right;

        return -1;
    }

}
