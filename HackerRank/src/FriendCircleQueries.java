import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FriendCircleQueries {

    static class Graph {

        private HashMap<Integer, List<Integer>> adjacencyList;

        public Graph(){
            adjacencyList = new HashMap<>();
        }

        public void addEdge(int start, int end){
            if (adjacencyList.containsKey(start)){
                List<Integer> adjacentVertices = adjacencyList.get(start);
                adjacentVertices.add(end);
                adjacencyList.put(start, adjacentVertices);
            }
            else {
                List<Integer> vertices = new ArrayList<>();
                vertices.add(end);
                adjacencyList.put(start, vertices);
            }

            if (adjacencyList.containsKey(end)){
                List<Integer> adjacentVertices = adjacencyList.get(end);
                adjacentVertices.add(start);
                adjacencyList.put(end, adjacentVertices);
            }
            else {
                List<Integer> vertices = new ArrayList<>();
                vertices.add(start);
                adjacencyList.put(end, vertices);
            }
        }

        public int BFS(){
            HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
            int maxCircle = 0;
            for (Integer vertex: adjacencyList.keySet()){
                if (!visited.getOrDefault(vertex, false)){
                    int circle = BFSUtil(vertex, visited);
                    if (circle > maxCircle)
                        maxCircle = circle;
                }
            }
            return maxCircle;
        }

        public int BFSUtil(int start, HashMap<Integer, Boolean> visited){
            int circleCount = 0;
            Queue<Integer> bfsQueue = new LinkedList<>();
            bfsQueue.offer(start);
            visited.put(start, true);
            while (!bfsQueue.isEmpty()){
                int expandVertex = bfsQueue.poll();
                List<Integer> adjacentVertices = adjacencyList.get(expandVertex);
                for (Integer vertex: adjacentVertices){
                    if (!visited.getOrDefault(vertex, false)){
                        visited.put(vertex, true);
                        bfsQueue.offer(vertex);
                        circleCount++;
                    }
                }
            }
            return circleCount + 1;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Graph g = new Graph();

        int queries = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < queries; ++i){
            String[] line = br.readLine().split(" ");
            g.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            System.out.println(g.BFS());
        }

    }


}
