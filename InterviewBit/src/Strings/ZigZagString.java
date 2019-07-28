package Strings;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a
 * given number of rows like this: (you may want to display this pattern
 * in a fixed font for better legibility)
 *
 * P.......A........H.......N
 * ..A..P....L....S....I...I....G
 * ....Y.........I........R
 * And then read line by line: PAHNAPLSIIGYIR
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * **Example 2 : **
 * ABCD, 2 can be written as
 *
 * A....C
 * ...B....D
 * and hence the answer would be ACBD.
 */
public class ZigZagString {
    public static String getZigZagString(String s, int numRows){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows - 1; ++i){
            for (int start = i; start < s.length();){
                sb.append(s.charAt(start));
                start = start + ((numRows - i - 1)) * 2;
            }
        }
        for (int i = numRows - 1; i < s.length();){
            sb.append(s.charAt(i));
            if (numRows == 2) i += numRows;
            else i += (numRows + 1);
        }
        return sb.toString();
    }

    public static String getZigZagStringCorrect(String s, int numRows){
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, n = s.length();
        int l = numRows - 1;
        while (i < numRows){
            j = i;
            while (j < n && sb.length() < n){
                sb.append(s.charAt(j));
                j += (l - (j%l)) * 2;
            }
            ++i;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(getZigZagStringCorrect("PAYPALISHIRING", 3));
        System.out.println(getZigZagStringCorrect("ABCD", 2));
    }
}
