package graphdsa;

import java.util.ArrayList;
import java.util.List;

/**
 * Given N * M field of O's and X's, where O=white, X=black
 * Return the number of black shapes. A black shape consists of one
 * or more adjacent X's (diagonals not included)
 *
 * Example:
 *
 * OOOXOOO
 * OOXXOXO
 * OXOOOXO
 *
 * answer is 3 shapes are  :
 * (i)    X
 *      X X
 * (ii)
 *       X
 *  (iii)
 *       X
 *       X
 * Note that we are looking for connected shapes here.
 *
 * For example,
 *
 * XXX
 * XXX
 * XXX
 * is just one single connected black shape.
 */
public class BlackShapes {
    public int black(ArrayList<String> mat) {
        int n = mat.size();
        int m = mat.get(0).length();
        int totalCount = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j){
                if (mat.get(i).charAt(j) == 'X' && !visited[i][j]){
                    //System.out.println("In BFS " + i + "   " + j);
                    ++totalCount;
                    bfs(mat, n, m, i, j, visited);
                }
                else {
                    visited[i][j] = true;
                }
            }
        }
        return totalCount;
    }

    public static void bfs(List<String> mat, int n, int m,
                           int startX, int startY, boolean[][] visited){
        if (startX >= 0 && startY >= 0 && startX < n && startY < m
                && mat.get(startX).charAt(startY) == 'X' && !visited[startX][startY]){
            //System.out.println(startX + "  " + startY);
            visited[startX][startY] = true;
            bfs(mat, n, m, startX - 1, startY, visited);
            bfs(mat, n, m, startX, startY - 1, visited);
            bfs(mat, n, m, startX + 1, startY, visited);
            bfs(mat, n, m, startX, startY + 1, visited);
        }
    }
}
