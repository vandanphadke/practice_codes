import java.util.*;

public class KruskalsMSTAlgo {

    /*public static int kruskalsMSTAlgo(GraphAdjListUndirected graph){

        int V = graph.getNoofVertices();
        DisjointSets ds = new DisjointSets(V);

        HashMap<Edge> allEdges = new ArrayList<>();
        for (int i = 0; i < V; ++i){
            for(Edge edge: graph.getEdges(i))
                allEdges.add(edge);
        }

        Collections.sort(allEdges);
        for (Edge edge: allEdges){
            int source = edge.g;
            int destination = B.get(i).get(1);
            int edgeWeight = B.get(i).get(3);
            if (!(ds.find(source - 1) == ds.find(destination - 1))){
                weight += edgeWeight;
                ds.union(source, destination);
            }

        }



    }*/


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