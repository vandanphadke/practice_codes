public class RepeatNby3 {

    public static void main(String[] args){
        int[] arr = {20, 30, 10, 10, 5, 4, 20, 1, 2};
        System.out.println(findnby3Element(arr));
    }

    private static int findnby3Element(int[] arr) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == first){
                ++count1;
            }
            else if (arr[i] == second){
                ++count2;
            }
            else if (count1 == 0){
                first = arr[i];
                count1 = 1;
            }
            else if (count2 == 0){
                second = arr[i];
                count2 = 1;
            }
            else {
                --count1;
                --count2;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0 ; i < arr.length; ++i){
            if (arr[i] == first)
                ++count1;
            if (arr[i] == second)
                ++count2;
        }

        if (count1 > (arr.length / 3))
            return first;
        else if(count2 > (arr.length / 3))
            return second;
        return -1;

    }

}
