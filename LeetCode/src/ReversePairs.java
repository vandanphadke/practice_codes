/**
 * Q: Given an array nums, we call (i, j)
 *    an important reverse pair if i < j and nums[i] > 2*nums[j].
 *
 * You need to return the number of important reverse pairs in the given array.
 *
 * Example1:
 *
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 *
 * Input: [2,4,3,5,1]
 * Output: 3
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return sortAndCount(nums, 0, nums.length - 1);
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public int sortAndCount(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            int count = sortAndCount(arr, l, m) + sortAndCount(arr , m+1, r);

            int j = m + 1;
            for (int i=l; i<=m; ++i){
                while (j <= r && arr[i] > (long)2*arr[j])
                    j++;
                count += j - (m+1);
            }

            // Merge the sorted halves
            merge(arr, l, m, r);
            return count;
        }
        else
            return 0;
    }

}
