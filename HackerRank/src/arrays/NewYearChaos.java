package arrays;


/*
* Q: https://www.hackerrank.com/challenges/new-year-chaos/problem
*
* Find minimum number of bribes necessary to get to the current
* configuration (only two bribes possible per person)
*
* */
public class NewYearChaos {

    public static void main(String[] args){
        int[] arr = new int[]{2,1,5,3,4};
        findMinimumBribes(arr);
        int[] arr1 = new int[]{2,5,1,3,4};
        findMinimumBribes(arr1);
    }

    private static void findMinimumBribes(int[] arr) {
        int answer = 0;
        for (int i = arr.length - 1; i >=0; --i){
            if (arr[i] - (i+1) > 2){
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, arr[i] - 2);j < i; ++j){
                if (arr[j] > arr[i])
                    ++answer;
            }
        }
        System.out.println(answer);
    }
}
