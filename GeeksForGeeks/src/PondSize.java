/**
 * Pond Sizes: You have an integer matrix representing a plot of land, where the value at that loca­
 * tion represents the height above sea level. A value of zero indicates water. A pond is a region of
 * water connected vertically, horizontally, or diagonally. The size of the pond is the total number of
 * connected water cells. Write a method to compute the sizes of all ponds in the matrix.
 *
 *
 * EXAMPLE
 * Input:
 * 0 2 1 0
 * 0 1 0 1
 * 1 1 0 1
 * 0 1 0 1
 *
 *
 * The output is: (2,4,1) in any order

 */

public class PondSize {
    public static void main(String[] args){
        int[][] pond = new int[][]{{0,2,1,0}, {0,1,0,1} ,{1,1,0,1} ,{0,1,0,1}};
        getPoodles(pond);


    }

    private static void getPoodles(int[][] pond) {
        int n = pond.length;
        int m = pond[0].length;

        boolean[][] visited = new boolean[n][m];
        /*for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j){
                if (pond[i][j] == 0){
                    int size =
                }
                visited[i][j] = true;
            }
        }*/

    }


}
