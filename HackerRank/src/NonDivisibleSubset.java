import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NonDivisibleSubset {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine().split(" ")[1]);
        String[] numberStr = br.readLine().split(" ");
        int[] numbers = new int[numberStr.length];
        for (int i = 0 ; i < numberStr.length; ++i)
            numbers[i] = Integer.parseInt(numberStr[i]);

        System.out.println(getMaximaxSubset(numbers, k));
    }

    private static int getMaximaxSubset(int[] numbers, int k) {
        int maxLength = 0;
        int[] moduloNos = new int[k];
        for (int i = 0; i < numbers.length; i++)
            moduloNos[numbers[i] % k]++;

        if (moduloNos[0] != 0)
            ++maxLength;

        for (int i = 1; i <= k/2; ++i){
            int temp = 0;
            if(moduloNos[i] > moduloNos[k-i])
                temp = moduloNos[i];
            else
                temp = moduloNos[k-i];

            if((k%2 == 0) && (i == k/2) && (moduloNos[k/2] > 0))
                temp = 1;

            maxLength+= temp;

        }

        return maxLength;
    }

}

