public class Maxjminusi {

    public static void main(String[] args){
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(getMaxIndexDiff(arr));


    }

    private static int getMaxIndexDiff(int[] arr) {
        int n = arr.length;
        int[] minimums = new int[n];
        int[] maximums = new int[n];
        int currentMin = Integer.MAX_VALUE;
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0 ; i < n; ++i){
            if (arr[i] < currentMin){
                currentMin = arr[i];
            }
            minimums[i] = currentMin;
        }

        for (int i = n-1 ; i >= 0; --i){
            if (arr[i] > currentMax){
                currentMax = arr[i];
            }
            maximums[i] = currentMax;
        }

        int i = 0, j = 0, diff = Integer.MIN_VALUE;
        while (i < arr.length && j < arr.length){
            if (minimums[i] < maximums[j]){
                diff = Math.max(diff, j-i);
                ++j;
            }
            else
                ++i;
        }
        return diff;
    }

}
