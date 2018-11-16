import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Q: Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA”
 * and “DEFGAB”, with length 6. For “BBBB” the longest substring is “B”, with length 1.
 *
 * For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7.
 */
public class LongestSubstringUniqueChars {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(getLongestSubstring(br.readLine()));

    }

    private static int getLongestSubstring(String line) {
        int[] charIndex = new int[25];
        Arrays.fill(charIndex, -1);
        int maxLength = Integer.MIN_VALUE;
        int currentLength = 0;
        charIndex[line.charAt(0) - 'a'] = 0;


        for (int i = 1 ; i < line.length(); ++i){
            char current = line.charAt(i);
            int currentCharInt = (int)current - (int)'a';
            int prevIndex = charIndex[currentCharInt];

            if (prevIndex == -1 || i - currentLength > prevIndex)
                ++currentLength;
            else {
                if (currentLength > maxLength)
                    maxLength = currentLength;

                currentLength = i - prevIndex;

            }
            charIndex[currentCharInt] = i;
        }
        if (currentLength > maxLength)
            maxLength = currentLength;

        return maxLength;
    }
}
