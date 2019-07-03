package bitmanipulation;

import java.util.Collections;

/**
 *
 * Reverse bits of an 32 bit unsigned integer
 *
 * Example 1:
 *
 * x = 0,
 *
 *           00000000000000000000000000000000
 * =>        00000000000000000000000000000000
 * return 0
 *
 * Example 2:
 *
 * x = 3,
 *
 *           00000000000000000000000000000011
 * =>        11000000000000000000000000000000
 * return 3221225472
 *
 * Since java does not have unsigned int, use long
 *
 */
public class ReverseBits {

    public long reverse(long a) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(a));
        sb.insert(0, String.join("", Collections.nCopies(32-sb.length(), "0")));
        String  s = sb.reverse().toString();
        return Long.parseLong(s, 2);
    }

}
