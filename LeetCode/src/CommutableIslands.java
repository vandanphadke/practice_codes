import java.util.*;

public class CommutableIslands {

    /*static class Graph {
        public Map<Integer, ArrayList<Edge>> Adjacency_List;
        int no_of_vertices;

        public Graph(int number_of_vertices) {
            this.no_of_vertices = number_of_vertices;
            Adjacency_List = new HashMap<Integer, ArrayList<Edge>>();
            for (int i = 0; i < number_of_vertices; i++)
                Adjacency_List.put(i, new ArrayList<Edge>());

        }

        public void addEdge(int source, int destination, int weight) {
            if (source > Adjacency_List.size() || destination > Adjacency_List.size()) {
                System.out.println("the vertex entered in not present ");
                return;
            }
            ArrayList<Edge> slist = Adjacency_List.get(source);
            slist.add(new Edge(destination, weight));
            ArrayList<Edge> dlist = Adjacency_List.get(destination);
            dlist.add(new Edge(source, weight));
        }

        public ArrayList<Edge> getEdges(int source) {
            if (source > Adjacency_List.size()) {
                System.out.println("the vertex entered is not present");
                return null;
            }
            return Adjacency_List.get(source);
        }
    }

    static class Edge{
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }


    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph g = new Graph(A);
        for (ArrayList<Integer> edge: B){
            g.addEdge(edge.get(0), edge.get(1), edge.get(2));

        }
        return PrimsAlgo(g);
    }

    public static int PrimsAlgo(Graph graph){
        int max_vertices = graph.no_of_vertices;
        ArrayList<Integer> settled = new ArrayList<Integer>();
        ArrayList<Integer> unsettled = new ArrayList<Integer>();
        int weight = 0 ;

        //Considering 0 as the source vertex
        settled.add(0);
        for(int i = 1 ; i < max_vertices ; i++)
            unsettled.add(i);

        for(int i = 0 ; i < max_vertices - 1 ; i++){
            int min_edge = Integer.MAX_VALUE;
            int min_weight = Integer.MAX_VALUE;
            for(int src: settled){
                for(Edge edge: graph.getEdges(src)){
                    if(edge.weight < min_weight && unsettled.contains(edge.destination)){
                        min_edge = edge.destination;
                        min_weight = edge.weight;
                    }
                }
            }
            weight+=min_weight;
            for(int k = 0 ; k < unsettled.size(); k++)
                if(unsettled.get(k) == min_edge)
                    unsettled.remove(k);
            settled.add(min_edge);
        }
        return weight;
    }*/

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Collections.sort(B, Comparator.comparingInt(x -> x.get(3)));
        int weight = 0;
        DisjointSets ds = new DisjointSets(A);
        for (int i = 0; i < B.size(); ++i){
            int source = B.get(i).get(0);
            int destination = B.get(i).get(1);
            int edgeWeight = B.get(i).get(3);
            if (!(ds.find(source - 1) == ds.find(destination - 1))){
                weight += edgeWeight;
                ds.union(source, destination);
            }
        }
        return weight;
    }


}

class DisjointSets {

    int nSets;
    int[] parents;
    int[] rank;

    public DisjointSets(int noSets){
        this.nSets = noSets;
        this.parents = new int[noSets];
        this.rank = new int[noSets];
        this.makeSet();
    }

    public void makeSet(){
        for (int i = 0 ; i < parents.length; ++i)
            parents[i] = i;

        Arrays.fill(rank, 1);
    }

    public int find(int no){
        if (parents[no] != no){
            parents[no] = find(parents[no]);
        }

        return parents[no];
    }

    public void union(int x, int y){
        int a = find(x), b = find(y);
        if (a != b){
            if (rank[a] > rank[b]){
                parents[b] = a;
            }
            else if (rank[b] > rank[a]){
                parents[a] = b;
            }
            else {
                parents[b] = a;
                ++rank[b];
            }
        }
    }

}