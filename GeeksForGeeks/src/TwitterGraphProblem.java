import java.util.*;

class Tree {

    public Map<Integer, ArrayList<Integer>> Adjacency_List;
    int no_of_vertices;
    public HashMap<Integer, Integer> nodeValues;

    public Tree(int n, List<Integer> values) {
        this.no_of_vertices = n;
        Adjacency_List = new HashMap<>();
        for (int i = 0; i < n; i++)
            Adjacency_List.put(i, new ArrayList<>());

        for (int i = 0; i < values.size(); i++) {
            nodeValues.put(i, values.get(i));
        }
    }

    public void addEdge(int source, int destination) {
        ArrayList<Integer> slist = Adjacency_List.get(source);
        slist.add(destination);
    }

    public List<Integer> getEdges(int vertex){
        return Adjacency_List.get(vertex);
    }

    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public int graphBFS(int start){
        int count = 0;
        boolean[] visited = new boolean[no_of_vertices];
        visited[start] = true;
        if (isPrime(nodeValues.get(start))){
            ++count;
        }

        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(start);

        while(!bfsQueue.isEmpty()){
            int v = bfsQueue.remove();
            List<Integer> adjacent = Adjacency_List.get(v);
            for (int i = 0 ; i < adjacent.size(); ++i){
                int adj = adjacent.get(i);
                if (!visited[adj]){
                    visited[adj] = true;
                    if (isPrime(nodeValues.get(adj))){
                        ++count;
                    }
                    bfsQueue.add(adj);
                }
            }
        }
        return count;
    }

}

public class TwitterGraphProblem {
    public static List<Integer> primeQuery(int n, List<Integer> first,
                                           List<Integer> second,
                                           List<Integer> values,
                                           List<Integer> queries){

        Tree tree = new Tree(n, values);
        for (int i = 0 ; i < n; ++i){
            tree.addEdge(first.get(i), second.get(i));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < queries.size(); ++i){
            int start = queries.get(i);
            result.add(tree.graphBFS(start));

        }
        return result;
    }




}
