package GeeksForGeeks;

/*
* Link: https://www.geeksforgeeks.org/ugly-numbers/
* Question:
* Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
* The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the
* first 11 ugly numbers. By convention, 1 is included.
*
* Given a number n, the task is to find n’th Ugly number.
* */

public class UglyNumbers {
    public static void main(String[] args){
        int n = 150;
        System.out.println(getUglyNumber(n));
    }

    public static int getUglyNumber(int n){
        int[] numbers = new int[n];
        numbers[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; ++i){
            int nextMul2 = numbers[i2]*2;
            int nextMul3 = numbers[i3]*3;
            int nextMul5 = numbers[i5]*5;

            int nextNumber = Math.min(nextMul2, Math.min(nextMul3, nextMul5));
            numbers[i] = nextNumber;

            if (nextNumber == nextMul2)
                ++i2;
            if (nextNumber == nextMul3)
                ++i3;
            if (nextNumber == nextMul5)
                ++i5;
        }
        return numbers[n-1];
    }

}
