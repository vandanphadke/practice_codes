package graphdsa;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Find largest distance
 * Given an arbitrary unweighted rooted tree which consists of N
 * (2 <= N <= 40000) nodes. The goal of the problem is to find largest distance
 * between two nodes in a tree. Distance between two nodes is a number of edges on a
 * path between the nodes (there will be a unique path between any pair of nodes since
 * it is a tree). The nodes will be numbered 0 through N - 1.
 *
 * The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N).
 * Exactly one of the i’s will have P[i] equal to -1, it will be root node.
 *
 *  Example:
 * If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks
 * like this:
 *           0
 *        /  |  \
 *       1   2   3
 *                \
 *                 4
 *  One of the
 */
public class LargestDistance {
    static class Node {
        int val;
        int distance;

        public Node(int val, int distance) {
            this.val = val;
            this.distance = distance;
        }
    }

    public static int returnDistance(List<Integer> arr){
        ArrayList<ArrayList<Integer>> adjList = buildAdjList(arr);
        int x = returnFarthestNode(adjList, 0).val;
        return returnFarthestNode(adjList, x).distance;
    }

    public static ArrayList<ArrayList<Integer>> buildAdjList(List<Integer> arr){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < arr.size(); ++i)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < arr.size(); ++i){
            int parent = arr.get(i);
            if (parent != -1){
                adjList.get(parent).add(i);
                adjList.get(i).add(parent);
            }
        }
        return adjList;
    }

    public static Node returnFarthestNode(ArrayList<ArrayList<Integer>> adjList, int start){
        Node maxNode = null;
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Node(start, 0));
        boolean[] visited = new boolean[adjList.size()];
        visited[start] = true;

        while (!bfsQueue.isEmpty()){
            Node v = bfsQueue.poll();

            if (maxNode == null || maxNode.distance < v.distance){
                maxNode = v;
            }

            for (int adjancent : adjList.get(v.val)){
                if (!visited[adjancent]){
                    visited[adjancent] = true;
                    bfsQueue.add(new Node(adjancent, v.distance + 1));
                }
            }
        }
        return maxNode;
    }

    public static void main(String[] args){
        List<Integer> arr = Arrays.asList(-1, 0, 0, 0, 3);
        System.out.println(returnDistance(arr));
    }
}
