package graphdsa;

import java.util.*;

/**
 * There are n islands and there are many bridges connecting them.
 * Each bridge has some cost attached to it.
 *
 * We need to find bridges with minimal cost such that all islands are connected.
 *
 * It is guaranteed that input data will contain at least one possible scenario
 * in which all islands are connected with each other.
 *
 * Example :
 * Input
 *
 *          Number of islands ( n ) = 4
 *          1 2 1
 *          2 3 4
 *          1 4 3
 *          4 3 2
 *          1 3 10
 * In this example, we have number of islands(n) = 4 . Each row then represents a
 * bridge configuration. In each row first two numbers represent the islands number
 * which are connected by this bridge and the third integer is the cost associated
 * with this bridge.
 *
 * In the above example, we can select bridges 1(connecting islands 1 and 2 with
 * cost 1), 3(connecting islands 1 and 4 with cost 3), 4(connecting islands 4 and 3
 * with cost 2). Thus we will have all islands connected with the minimum possible
 * cost(1+3+2 = 6).
 * In any other case, cost incurred will be more.
 */
public class CommutableIslands {

    public static void main(String[] args){
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2, 1));
        edges.add(Arrays.asList(2, 3, 4));
        edges.add(Arrays.asList(1, 4, 3));
        edges.add(Arrays.asList(4, 3, 2));
        edges.add(Arrays.asList(1, 3, 10));
        System.out.println(getBridgesCost(edges, 4));
    }

    public static int getBridgesCost(List<List<Integer>> edges, int n){
        Collections.sort(edges, Comparator.comparingInt(o -> o.get(2)));
        DisjointSets sets = new DisjointSets(n);
        int totalCost = 0;
        for (List<Integer> edge : edges){
            if (sets.find(edge.get(0) - 1) != sets.find(edge.get(1) - 1)){
                sets.union(edge.get(0) - 1, edge.get(1) - 1);
                totalCost = totalCost + edge.get(2);
            }
        }
        return totalCost;
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