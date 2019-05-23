package DisjointSets;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        DisjointSets ds = new DisjointSets(5);
        System.out.println(ds.find(3));
        System.out.println(ds.find(2));

        ds.union(3,2);
        ds.union(3,1);
        ds.union(3,0);
        System.out.println(ds.find(3));
        System.out.println(ds.find(2));
        System.out.println(Arrays.toString(ds.rank));

    }
}
