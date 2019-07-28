package Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Read more details about roman numerals at Roman Numeric System
 *
 * Example :
 *
 * Input : "XIV"
 * Return : 14
 * Input : "XX"
 * Output : 20
 *
 */
public class RomanToInteger {

    public int returnInteger(String roman){
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < roman.length(); ++i){
            int current = romanMap.get(roman.charAt(i));
            if (i + 1 < roman.length()){
                int next = romanMap.get(roman.charAt(i+1));
                if (current >= next){
                    result += current;
                }
                else {
                    result += (next - current);
                    ++i;
                }
            }
            else {
                result = result + current;
            }
        }

        return result;
    }
}
