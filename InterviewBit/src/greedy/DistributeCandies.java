package greedy;

import java.util.Arrays;
import java.util.List;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 *  You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Sample Input :
 *
 * Ratings : [1 2]
 * Sample Output :
 *
 * 3
 * The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1
 * candy as 1 is its neighbor. So rating 2 candidate gets 2 candies. In total,
 * 2+1 = 3 candies need to be given out.
 */
public class DistributeCandies {

    public static int getTotalCandies(List<Integer> ratings){
        int[] candies = new int[ratings.size()];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.size(); ++i){
            if (ratings.get(i) > ratings.get(i-1))
                candies[i] = candies[i-1] + 1;
        }

        for (int i = ratings.size() - 2; i >= 0; --i){
            if (ratings.get(i) > ratings.get(i + 1)){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        return Arrays.stream(candies).sum();
    }

}
