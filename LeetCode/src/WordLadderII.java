import java.lang.reflect.Array;
import java.util.*;

/**
 * Q: https://www.interviewbit.com/problems/word-ladder-ii/
 *
 * Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.
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
 *  Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 */
public class WordLadderII {

    public static void main(String[] args){
        System.out.println(checkEdgeExists("abc", "abd"));
        System.out.println(checkEdgeExists("abc", "bbd"));
    }


    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        Graph g = new Graph();

        for (int i = 0 ; i < dict.size(); ++i){
            for (int j = i + 1; j < dict.size(); ++j){
                if (checkEdgeExists(dict.get(i), dict.get(j))){
                    g.addVertex(dict.get(i));
                    g.addVertex(dict.get(j));
                    g.addEdge(dict.get(i), dict.get(j));
                }

            }
        }

        g.addVertex(start);
        g.addVertex(end);
        for (String word: dict){
            if (checkEdgeExists(start, word)){
                g.addEdge(start, word);
            }
            if (checkEdgeExists(end, word)){
                g.addEdge(end, word);
            }
        }



        return null;
    }

    public void BFS(Graph g, String startWord)
    {
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<String, ArrayList<String>> predecessors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();

        LinkedList<String> queue = new LinkedList<>();

        for (String vertex: g.verticesMap.keySet()){
            visited.put(vertex, false);
            predecessors.put(vertex, new ArrayList<>());
            distance.put(vertex, Integer.MAX_VALUE);
        }

        visited.put(startWord, true);
        queue.add(startWord);
        distance.put(startWord, 0);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            String current = queue.poll();
            System.out.print(current + " ");

            List<String> adjacentVertices = g.verticesMap.get(current);

            for (String vertex: adjacentVertices)
            {
                if (!visited.get(vertex) && distance.get(vertex) > distance.get(current) + 1)
                {
                    visited.put(vertex, true);
                    queue.add(vertex);
                    predecessors.get(vertex).add(current);

                }
            }
        }
    }

    public static boolean checkEdgeExists(String word1, String word2){
        boolean found = false;
        for (int i = 0 ; i < word1.length(); ++i){
            if (word1.charAt(i) != word2.charAt(i)){
                if (found)
                    return false;
                else
                    found = true;
            }

        }
        return true;
    }

}

class Graph {

    HashMap<String, ArrayList<String>> verticesMap;
    int currentVertices;

    public Graph(){
        verticesMap = new HashMap<>();
        this.currentVertices = 0;
    }

    public void addVertex(String vertexName){
        if (!verticesMap.containsKey(vertexName)){
            verticesMap.put(vertexName, new ArrayList<>());
            ++this.currentVertices;
        }
    }

    public void addEdge(String word1, String word2){
        if (!verticesMap.containsKey(word1)){
            this.addVertex(word1);
        }

        if (!verticesMap.containsKey(word2)){
            this.addVertex(word2);
        }

        verticesMap.get(word1).add(word2);
        verticesMap.get(word2).add(word1);
    }

    public int getNumberofVertices(){
        return this.currentVertices;
    }
}