import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args){
        int[] arr = new int[]{3, 1, 1, 7, 4, 4, 5, 6};
        int[] sortedarr = countingSort(arr);
        System.out.println(Arrays.toString(sortedarr));
    }

    public static int[] countingSort(int[] unsortedArr){
        int arrMin = getMinimum(unsortedArr);
        int arrMax = getMaximum(unsortedArr);

        //Create count array
        int[] countArr = new int[arrMax - arrMin + 1];
        
        //Set frequencies
        for (int i = 0; i < unsortedArr.length; i++)
            ++countArr[unsortedArr[i] - arrMin];

        //Add previous element
        for (int i = 1; i < countArr.length; i++)
            countArr[i] = countArr[i-1] + countArr[i];

        //Create sorted array
        int[] sortedArr = new int[unsortedArr.length];
        for (int i = 0; i < unsortedArr.length; i++) {
            sortedArr[countArr[unsortedArr[i] - arrMin] - 1] = unsortedArr[i];
            --countArr[unsortedArr[i] - arrMin];
        }

        return sortedArr;
    }

    public static int getMinimum(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i: arr)
            if (i < min)
                min = i;
        return min;
    }

    public static int getMaximum(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i: arr)
            if (i > max)
                max = i;
        return max;
    }

}
