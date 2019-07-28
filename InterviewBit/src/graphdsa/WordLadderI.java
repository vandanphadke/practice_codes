package graphdsa;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest
 * transformation sequence from start to end, such that:
 *
 * You must change exactly one character in every transformation
 * Each intermediate word must exist in the dictionary
 * Example :
 *
 * Given:
 *
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note that we account for the length of the transformation path instead of the number of transformation itself.
 *
 *  Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadderI {

    public static void main(String[] args){
        List<String> arr = Arrays.asList("hot","dot","dog","lot","log");
        ArrayList<String> arr1 = new ArrayList<>(arr);
        System.out.println(getTransformationLength("hit", "cog", arr1));
    }


    public static int getTransformationLength(String start, String end, ArrayList<String> dict){
        if(start.equals(end)) return 1;
        dict.add(start);
        dict.add(end);
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();
        for (String word : dict){
            adjList.put(word, new ArrayList<>());
        }
        for (int i = 0; i < dict.size(); ++i){
            for (int j = i+1; j < dict.size(); ++j){
                if (checkEditDistance(dict.get(i), dict.get(j))){
                    adjList.get(dict.get(i)).add(dict.get(j));
                    adjList.get(dict.get(j)).add(dict.get(i));
                }
            }
        }
        return bfs(adjList, start, end) + 1;
    }

    static class NodeDist {
        String node;
        int distance;

        public NodeDist(String node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static int bfs(HashMap<String, ArrayList<String>> adjList, String start, String end){
        Queue<NodeDist> bfsQueue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        bfsQueue.add(new NodeDist(start, 0));
        visited.add(start);
        while (!bfsQueue.isEmpty()){
            NodeDist current = bfsQueue.poll();
            for (String adjacent : adjList.get(current.node)){
                if (!visited.contains(adjacent)){
                    if (adjacent.equals(end)){
                        return current.distance + 1;
                    }
                    visited.add(adjacent);
                    bfsQueue.add(new NodeDist(adjacent, current.distance + 1));
                }
            }
        }
        return 0;
    }


    public static boolean checkEditDistance(String word1, String word2){
        boolean flag = false;
        for (int i = 0; i < word1.length(); ++i){
            if (word1.charAt(i) != word2.charAt(i)){
                if (!flag){
                    flag = true;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
