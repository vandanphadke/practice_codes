package Arrays;

import java.util.List;

/**
 *  Given a read only array of n + 1 integers between 1 and n,
 *  find one number that repeats in linear time using less
 *  than O(n) space and traversing the stream sequentially O(1) times.
 *
 * Sample Input:
 *
 * [3 4 1 4 1]
 * Sample Output:
 *
 * 1
 * If there are multiple possible answers
 * ( like in the sample case above ), output any one.
 *
 * If there is no duplicate, output -1
 *
 */
public class FindDuplicate {

    public static void main(String[] args){
        
    }

    public int repeatedNumber(final List<Integer> arr) {
        int n = arr.size();
        int nSqrt = (int)Math.sqrt(n);
        int numBlocks = (int)(n / nSqrt) + 1;
        int[] blockCounts = new int[numBlocks];

        for (int num: arr){
            int blockId = (num - 1) / nSqrt;

            if (blockId >= numBlocks){
                ++blockCounts[numBlocks - 1];
                continue;
            }

            blockCounts[blockId]++;
        }


        return 0;


    }
}
