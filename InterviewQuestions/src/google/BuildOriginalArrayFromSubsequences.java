package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given an integer N and valid subsequences of an array of integers where every element
 * is distinct and from the range [0, N – 1], the task is to find the original array.
 *
 * Examples:
 *
 * Input: N = 6, v[] = {
 * {1, 2, 3},
 * {1, 2},
 * {3, 4},
 * {5, 2},
 * {0, 5, 4}}
 * Output: 0 1 5 2 3 4
 *
 * Input: N = 10, v[] = {
 * {9, 1, 2, 8, 3},
 * {6, 1, 2},
 * {9, 6, 3, 4},
 * {5, 2, 7},
 * {0, 9, 5, 4}}
 * Output: 0 9 6 5 1 2 8 7 3 4
 */
public class BuildOriginalArrayFromSubsequences {
    public static void main(String[] args){
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(1, 2);
        List<Integer> c = Arrays.asList(3, 4);
        List<Integer> d = Arrays.asList(5, 2);
        List<Integer> e = Arrays.asList(0, 5, 4);
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(a);arr.add(b);arr.add(c);arr.add(d);arr.add(e);
        System.out.println(constructArrayFromSub(arr, 6));
    }

    public static List<Integer> constructArrayFromSub(List<List<Integer>> subarrays, int n){
        int[][] adjMat = new int[n][n];
        for (List<Integer> sub : subarrays){
            for (int i = 0; i < sub.size() - 1; ++i){
                adjMat[sub.get(i)][sub.get(i+1)] = 1;
            }
        }
        return topologicalSort(adjMat, n);
    }

    // Assumption that the array is connected.
    public static List<Integer> topologicalSort(int[][] adjMat, int n){
        boolean[] visited = new boolean[n];
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; ++i){
            if (!visited[i]){
                dfs(adjMat, visited, i, results);
            }
        }
        return results;
    }

    public static void dfs(int[][] adjMat, boolean[] visited, int start, List<Integer> results){
        Stack<Integer> dfsStack = new Stack<>();
        visited[start] = true;
        dfsStack.push(start);
        while (!dfsStack.isEmpty()){
            int v = dfsStack.peek();
            int adj = getUnvisitedVertex(adjMat, visited, v);
            if (adj == -1){
                results.add(0, dfsStack.pop());
            }
            else {
                visited[adj] = true;
                dfsStack.push(adj);
            }
        }
    }

    public static int getUnvisitedVertex(int[][] adjMat, boolean[] visited, int vertex){
        for (int i = 0; i < adjMat.length; ++i){
            if (adjMat[vertex][i] != 0 && !visited[i])
                return i;
        }
        return -1;
    }


}
