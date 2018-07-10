package GeeksForGeeks;

public class SubsetSum {
    public static void main(String[] args){
        int[] nos = {3, 34, 4, 12, 5, 2};
        int total = 13;
        System.out.println(isSubsetSum(nos, total));
    }

    public static boolean isSubsetSum(int[] numbers, int total){
        boolean[][] table = new boolean[total + 1][numbers.length + 1];
        for (int i = 0; i <= numbers.length; ++i)
            table[0][i] = true;

        for (int i = 1; i <= total; ++i){
            for (int j = 1; j <= numbers.length; ++j){
                boolean isAlreadyPossible = table[i][j-1];
                if (i >= numbers[j-1])
                    table[i][j] = isAlreadyPossible ||
                            table[(i - numbers[j-1])][j-1];
                else
                    table[i][j] = isAlreadyPossible;
            }
        }
        return table[total][numbers.length];
    }


}
