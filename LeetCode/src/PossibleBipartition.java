import java.util.*;

/**
 * https://leetcode.com/problems/possible-bipartition/description/
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered
 * a and b into the same group.
 * Return true if and only if it is possible to split everyone into two groups in this way.
 */
public class PossibleBipartition {

    public static void main(String[] args){
        int N = 4;
        int[][] dislikes = new int[][]{{1,2}, {1,3}, {2,3}};
        System.out.println(possibleBipartition(N, dislikes));
    }



    public static boolean possibleBipartition(int N, int[][] dislikes) {

        HashMap<Integer, List<Integer>> likesMap = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            int[] persons = dislikes[i];
            int person1 = persons[0];
            int person2 = persons[1];
            if (likesMap.containsKey(person1)){
                List<Integer> personSet = likesMap.get(person1);
                personSet.add(person2);
                likesMap.put(person1, personSet);
            }
            else {
                List<Integer> personSet = new ArrayList<>();
                personSet.add(person2);
                likesMap.put(person1, personSet);
            }
        }

        int[] bipartite = new int[N];
        Arrays.fill(bipartite, -1);
        bipartite[0] = 0;

        for (int i = 0; i < N; ++i){
            if (likesMap.containsKey(i + 1)){
                List<Integer> dislikedPersons = likesMap.get(i + 1);
                for (Integer person: dislikedPersons){
                    if (bipartite[person - 1] != -1 && bipartite[person - 1] != bipartite[i])
                        return false;
                    if (bipartite[person - 1] == -1)
                        bipartite[person - 1] = 1 - bipartite[i];
                }
            }
            System.out.println(Arrays.toString(bipartite));
        }

        System.out.println(Arrays.toString(bipartite));
        return true;
    }

}
