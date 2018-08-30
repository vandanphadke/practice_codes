import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Q: https://leetcode.com/problems/boats-to-save-people/description/
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 * Each boat carries at most 2 people at the same time, provided the sum of the weight of
 * those people is at most limit.
 * Return the minimum number of boats to carry every given person.
 * (It is guaranteed each person can be carried by a boat.)
 *
 * @author vandan
 */
public class BoatsToSavePeople {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] contents = br.readLine().split(" ");
        int[] people = Arrays.stream(contents).mapToInt(Integer::parseInt).toArray();
        int limit = Integer.parseInt(br.readLine());
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        if (people == null) return 0;
        Arrays.sort(people);
        int low = 0, high = people.length - 1, answer = 0;
        while (low <= high){
            if (people[low] + people[high] <= limit)
                ++low;
            --high;
            ++answer;
        }

        return answer;
    }


}
