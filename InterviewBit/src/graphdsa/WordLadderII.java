package graphdsa;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the shortest transformation sequence
 * from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * If there are multiple such sequence of shortest length, return all of them. Refer to
 * the example for more details.
 *
 * Example :
 *
 * Given:
 *
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 *
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 */
public class WordLadderII {
    public static void main(String[] args){
        List<String> arr = Arrays.asList("hot","dot","dog","lot","log");
        ArrayList<String> arr1 = new ArrayList<>(arr);
        System.out.println(getTransformationLength("hit", "cog", arr1));
    }


    public static List<List<String>> getTransformationLength(String start, String end, ArrayList<String> dict){
        if(start.equals(end)) return new ArrayList<>();
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
        HashMap<String, List<String>> parent = bfs(adjList, start);
        List<String> current = new ArrayList<>();
        List<List<String>> results = new ArrayList<>();
        resultDfs(parent, current, results, end);
        for (List<String> res : results)
            res.add(end);
        return results;
    }

    public static void resultDfs(HashMap<String, List<String>> parents, List<String> current,
                                 List<List<String>> results, String node){
        if (parents.get(node).size() == 0){
            results.add(new ArrayList<>(current));
        }
        else {
            for (String parent : parents.get(node)){
                current.add(0, parent);
                resultDfs(parents, current, results, parent);
                current.remove(0);
            }
        }
    }


    public static HashMap<String, List<String>> bfs(HashMap<String, ArrayList<String>> adjList, String start){
        Queue<String> bfsQueue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashMap<String, Integer> distance = new HashMap<>();
        bfsQueue.add(start);
        HashMap<String, List<String>> parent = new HashMap<>();
        parent.put(start, new ArrayList<>());
        visited.add(start);
        distance.put(start, 0);
        while (!bfsQueue.isEmpty()){
            String current = bfsQueue.poll();
            for (String adjacent : adjList.get(current)){
                if (!visited.contains(adjacent)){
                    visited.add(adjacent);
                    bfsQueue.add(adjacent);
                    List<String> par = new ArrayList<>();
                    par.add(current);
                    parent.put(adjacent, par);
                    distance.put(adjacent, distance.get(current) + 1);
                }
                else {
                    if (distance.get(adjacent) == distance.get(current) + 1){
                        parent.get(adjacent).add(current);
                    }
                }
            }
        }
        return parent;
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
