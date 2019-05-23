package twitter;

import java.util.*;


class Tree {

    int noVertices;
    Map<Integer, ArrayList<Integer>> adjList;
    HashMap<Integer, Integer> nodeValues;
    int[] memoize;
    int[] parents;

    public Tree(int n, List<Integer> values) {

        // Init
        this.noVertices = n;
        this.nodeValues = new HashMap<>();
        adjList = new HashMap<>();
        parents = new int[noVertices];
        memoize = new int[noVertices];
        Arrays.fill(memoize, -1);

        // Empty adjacency list
        for (int i = 0; i < n; i++)
            adjList.put(i, new ArrayList<>());

        // Enter values
        for (int i = 0; i < values.size(); i++) {
            nodeValues.put(i, values.get(i));
        }

    }

    public void addEdge(int source, int destination) {
        ArrayList<Integer> slist = adjList.get(source);
        slist.add(destination);
    }

    public List<Integer> getEdges(int vertex){
        return adjList.get(vertex-1);
    }

    boolean isPrime(int n) {
        if(n == 1)
            return false;

        for(int i=2;i<=n/2;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public void smallBFS(){
        Arrays.fill(parents, -1);
    
        boolean[] visited = new boolean[noVertices];
        visited[0] = true;

        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(0);

        while(!bfsQueue.isEmpty()){
            int v = bfsQueue.remove();
            List<Integer> adjacent = adjList.get(v);

            for (int i = 0 ; i < adjacent.size(); ++i){
                int adj = adjacent.get(i);
                if (!visited[adj]){
                    parents[adj] = v;
                    visited[adj] = true;
                    bfsQueue.add(adj);
                }
            }
        }
    }
//
//    public int graphBFS(int start){
//        //System.out.println("Start is " + start);
//
//        int count = 0;
//        boolean[] visited = new boolean[noVertices];
//        visited[start] = true;
//        if (isPrime(nodeValues.get(start))){
//            ++count;
//        }
//
//        Queue<Integer> bfsQueue = new LinkedList<>();
//        bfsQueue.add(start);
//
//        while(!bfsQueue.isEmpty()){
//            int v = bfsQueue.remove();
//            List<Integer> adjacent = adjList.get(v);
//            //System.out.println("Current is " + v  + "adjacent is " + adjacent);
//            for (int i = 0 ; i < adjacent.size(); ++i){
//                int adj = adjacent.get(i);
//                if(parents[v] != adj){
//                    if (!visited[adj]){
//                        //System.out.println("Visiting " + adj);
//                        //System.out.println("Value is " + nodeValues.get(adj));
//                        visited[adj] = true;
//                        if (isPrime(nodeValues.get(adj))){
//                            //System.out.println("Value is " + nodeValues.get(adj));
//                            ++count;
//                        }
//                        bfsQueue.add(adj);
//                    }
//                }
//            }
//        }
//        return count;
//    }

    public int getPrimes(int start){
        if (memoize[start] != -1){
            return memoize[start];
        }
        else {
            int my = 0;
            if (isPrime(nodeValues.get(start))) my = 1;
            List<Integer> adjacent = adjList.get(start);

            if (adjacent.size() == 1){
                memoize[start] = my;
                return my;
            }
            else {
                for (int adj: adjacent){
                    if(parents[start] != adj){
                        my += getPrimes(adj);
                    }
                }
                memoize[start] = my;
                return my;
            }
        }
    }

}
class Result {

    public static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values, List<Integer> queries) {
        
        Tree tree = new Tree(n, values);

        for(int i = 0 ; i < n-1; ++i){
            tree.addEdge(second.get(i) - 1, first.get(i) - 1);
            tree.addEdge(first.get(i) - 1, second.get(i) - 1);
        }
         
         tree.smallBFS();

        List<Integer> result=new ArrayList<>();
        for(Integer query:queries){
            result.add(tree.getPrimes(query-1));
        }
        System.out.println(Arrays.toString(tree.memoize));
        return result;
    }


    public static void main(String[] args){
        int n = 10;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        List<Integer> queries = new ArrayList<>();

        first.add(1);second.add(2);
        first.add(1);second.add(8);
        first.add(8);second.add(4);
        first.add(8);second.add(5);
        first.add(8);second.add(9);
        first.add(8);second.add(10);
        first.add(5);second.add(3);
        first.add(9);second.add(6);
        first.add(6);second.add(7);

        values.add(17);values.add(29);values.add(3);values.add(20);values.add(11);
        values.add(8);values.add(3);values.add(23);values.add(5);values.add(15);

        queries.add(6);queries.add(1);queries.add(8);queries.add(9);
        queries.add(6);queries.add(4);queries.add(3);

        System.out.println(primeQuery(n, first, second, values, queries));

    }

}
