package microsoft;

import java.util.*;

/**
 * Orders tasks based on their dependencies
 */
public class TaskOrdering {

    public static void main(String[] args){
        // Tasks are modeled as a map with its key
        // and an array of its dependencies
        HashMap<String, String[]> tasksMap = new HashMap<>();
        tasksMap.put("A", new String[]{"B", "C"});
        tasksMap.put("B", new String[]{"C", "D"});
        tasksMap.put("D", new String[]{"C"});

        // Print final result
        System.out.println(graphDFS(tasksMap));

    }

    /**
     * Depth-first traversal of a graph, the opposite order will give out the
     * topological sorting of the graph
     */
    public static List<String> graphDFS(HashMap<String, String[]> graph){

        // Map of Visited vertices
        HashMap<String, Boolean> visited = new HashMap<>();

        // Stack for iterative DFS
        Stack<String> dfsStack = new Stack<>();
        List<String> vertices = new ArrayList<>(graph.keySet());
        visited.put(vertices.get(0), true);
        dfsStack.push(vertices.get(0));
        List<String> result = new ArrayList<>();

        while(!dfsStack.isEmpty()){

            String v = getUnvisitedVertex(graph, visited, dfsStack.peek());

            // All adjacent vertices have been already visited
            if(v.isEmpty()){
                result.add(dfsStack.pop());
            }

            // Visit adjacent vertex and push into stack
            else{
                visited.put(v, true);
                dfsStack.push(v);
            }
        }
        return result;
    }

    /**
     * Gives out the first unvisited vertex for a given vertex.
     */
    private static String getUnvisitedVertex(HashMap<String, String[]> graph,
                                             HashMap<String, Boolean> visited,
                                             String vertex) {
        if (!graph.containsKey(vertex))
            return "";

        for (String adj: graph.get(vertex)){
            if (!visited.containsKey(adj))
                return adj;
        }
        return "";
    }
}
