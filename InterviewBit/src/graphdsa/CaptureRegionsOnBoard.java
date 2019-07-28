package graphdsa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 */
public class CaptureRegionsOnBoard {

    public void captureRegions(ArrayList<ArrayList<Character>> mat){
        int n = mat.size(), m = mat.get(0).size();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j){
                // do bfs on 0s at the edge
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1){
                    bfs(mat, n, m, i, j, visited);
                }
            }
        }

        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j){
                if (mat.get(i).get(j) == '-')
                    mat.get(i).set(j, 'O');
                else
                    mat.get(i).set(j, 'X');
            }
        }


    }

    public static void bfs(ArrayList<ArrayList<Character>> mat, int n, int m,
                           int startX, int startY, boolean[][] visited){
        if (startX >= 0 && startY >= 0 && startX < n && startY < m
                && mat.get(startX).get(startY) == 'O' && !visited[startX][startY]){
            visited[startX][startY] = true;
            mat.get(startX).set(startY, '-');
            bfs(mat, n, m, startX - 1, startY, visited);
            bfs(mat, n, m, startX, startY - 1, visited);
            bfs(mat, n, m, startX + 1, startY, visited);
            bfs(mat, n, m, startX, startY + 1, visited);
        }
    }
}
