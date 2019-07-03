package bitmanipulation;

/**
 *
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 *
 * Example:
 *
 * The 32-bit integer 11 has binary representation
 *
 * 00000000000000000000000000001011
 * so the function should return 3.
 *
 * Note that since Java does not have unsigned int, use long for Java
 *
 */
public class NumberOf1Bits {

    public int getNumberOfOneBits(long unsignedNum){
        int numBits = 0;
        while (unsignedNum > 0){
            if (unsignedNum % 2 == 1)
                ++numBits;
            unsignedNum /= 2;
        }
        return numBits;
    }
}
