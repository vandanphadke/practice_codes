package DisjointSets;

import java.util.Arrays;

/**
 * Implement Disjoint sets using forests as a Data Structure
 * Also implement Union-Find and Path Compression Heuristics
 *
 */
public class DisjointSets {

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
