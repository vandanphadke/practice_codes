package Strings;

/**
 *
 * Implement atoi to convert a string to an integer.
 *
 * Example :
 *
 * Input : "9 2704"
 * Output : 9
 * Note: There might be multiple corner cases here.
 * Clarify all your doubts using “See Expected Output”.
 *
 */
public class ATOI {

    public static void main(String[] args){
        convertStringToInt("7 U 0 T7165 0128862 089 39 5");
    }

    public static int convertStringToInt(String num){
        if(num == null || num.length() == 0)
            return 0;

        num = num.trim();
        boolean isNeg = false, isOverflow = false;
        int start = 0;
        if (num.charAt(0) == '-'){
            isNeg = true;
            ++start;
        }
        else if (num.charAt(0) == '+'){
            ++start;
        }

        long currentNum = 0;

        while (start < num.length()){
            if (num.charAt(start) >= '0' && num.charAt(start) <= '9'){
                currentNum = (currentNum * 10) + (num.charAt(start) - '0');
                if (currentNum > Integer.MAX_VALUE){
                    isOverflow = true;
                    break;
                }
            }
            else
                break;
        }

        if (isOverflow && isNeg) return Integer.MIN_VALUE;
        if (isOverflow) return Integer.MAX_VALUE;
        if (isNeg) return (int)(currentNum * (-1));
        return (int)(currentNum);
    }

}
