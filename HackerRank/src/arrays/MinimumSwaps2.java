package arrays;

public class MinimumSwaps2 {
    public static void main(String[] args){
        int[] arr = new int[]{2,4,5,1,3};
        System.out.println(getNumberSwaps(arr));
    }

    public static int getNumberSwaps(int[] arr){
        boolean[] visited = new boolean[arr.length];
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || (arr[i] == i+1))
                continue;
            else {
                int j = i;
                int cycle = 0;
                while (!visited[j]){
                    visited[j] = true;
                    ++cycle;
                    j = arr[j] - 1;
                }
                swaps += (cycle - 1);
            }
        }
        return swaps;
    }

}
