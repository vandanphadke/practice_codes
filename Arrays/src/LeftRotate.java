import java.util.Arrays;

/*
* Write a function rotate(ar[], d, n)
* that rotates arr[] of size n by d elements.
*
* Algorithm :
* The Juggling Algorithm
*
*
* */
public class LeftRotate {

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        leftRotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    private static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    private static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        for (int i = 0; i < gcd(arr.length, d); ++i){
            int temp = arr[i];
            int j = i;
            while (true){
                int k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }
}
