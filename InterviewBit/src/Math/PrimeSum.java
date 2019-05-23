package Math;

import java.util.ArrayList;

public class PrimeSum {

    public static void main(String[] args){
        System.out.println(getPrimeSum(100));
        System.out.println(isPrime(25));
    }

    public static ArrayList<Integer> getPrimeSum(int A){
        boolean[] isPrimeArr = new boolean[A+1];
        isPrimeArr[1] = true;
        isPrimeArr[2] = true;

        for (int i = 2; i <= A; ++i){
            if (isPrime(i)){
                isPrimeArr[i] = true;
                if (isPrime(A - i)){
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(A - i);
                    return result;
                }
            }
        }
        return new ArrayList<>();
    }

    public static boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); ++i){
            if (n % i == 0)
                return false;
        }
        return true;
    }


}
