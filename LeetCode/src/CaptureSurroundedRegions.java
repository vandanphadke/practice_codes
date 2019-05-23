import java.util.ArrayList;

/**
 * Q: https://www.interviewbit.com/problems/capture-regions-on-board/
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
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 */
public class CaptureSurroundedRegions {

    public void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size();
        int m = a.get(0).size();

        replaceAllZeroes(a, n, m);

        for (int i = 0 ; i < n; ++i){
            for (int j = 0 ; j < m; ++j){
                if (i == 0 || j == 0 || i == n-1 || j == m-1){
                    fillEdgeRegions(a, i, j, n, m);
                }
            }
        }
        replaceAllDashes(a, n, m);

    }

    public void fillEdgeRegions(ArrayList<ArrayList<Character>> mat, int xPos, int yPos, int n, int m){
        if (xPos < 0 || yPos < 0 || xPos >= n || yPos >= m){
            return;
        }

        if (mat.get(xPos).get(yPos) == '-'){
            mat.get(xPos).set(yPos, 'O');
        }
        else
            return;
        fillEdgeRegions(mat, xPos + 1, yPos, n, m);
        fillEdgeRegions(mat, xPos , yPos + 1, n, m);
        fillEdgeRegions(mat, xPos - 1, yPos, n, m);
        fillEdgeRegions(mat, xPos , yPos - 1, n, m);
    }


    public void replaceAllZeroes(ArrayList<ArrayList<Character>> mat, int n, int m){
        for (int i = 0 ; i < n; ++i){
            for (int j = 0 ; j < m; ++j){
                if (mat.get(i).get(j) == 'O'){
                    mat.get(i).set(j, '-');
                }
            }
        }
    }

    public void replaceAllDashes(ArrayList<ArrayList<Character>> mat, int n, int m){
        for (int i = 0 ; i < n; ++i){
            for (int j = 0 ; j < m; ++j){
                if (mat.get(i).get(j) == '-'){
                    mat.get(i).set(j, 'O');
                }
            }
        }
    }


}
