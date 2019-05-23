import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Q: https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/
 *
 * You are given an integer N. You have to find smallest multiple of N which consists of
 * digits 0 and 1 only. Since this multiple could be large, return it in form of a string.
 *
 */
public class SmallestMultiple0sand1s {

    public static void main(String[] args){
        System.out.println(multiple(55));
        System.out.println(multiple(2));
    }

    public static String multiple(int N) {
        Queue<String> nums = new LinkedList<>();
        HashSet<Integer> uniqueMods = new HashSet<>();
        nums.add("1");

        while(true){
            String current = nums.poll();
            //System.out.println(current + "");
            int mod = stringMod(current, N);
            if(mod == 0){
                return current;
            }
            else {
                if (!uniqueMods.contains(mod)){
                    uniqueMods.add(mod);
                    String num1 = current + "0";
                    String num2 = current + "1";
                    if(!uniqueMods.contains(num1)){
                        nums.add(num1);
                    }
                    if(!uniqueMods.contains(num2)){
                        nums.add(num2);
                    }
                }

            }

        }
        //return "";
    }

    public static int stringMod(String num, int N){
        int remainder = 0;
        for(int i = 0 ; i < num.length(); ++i){
            remainder = remainder * 10 + (num.charAt(i) - '0');
            remainder = remainder % N;
        }
        //System.out.println("Remainder is " + remainder);
        return remainder;

    }

}
