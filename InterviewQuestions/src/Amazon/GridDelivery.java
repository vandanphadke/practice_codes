package Amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a m * n grid, each representing a road (1), dead-end (0), and the destination cell (9)
 * find the shortest distance from the starting point (0, 0) to the destination cell. At any
 * given point you can visit 4 of your adjacent points (top, bottom, left, right).
 *
 * A simple BFS solution adding a special case for the dead-ends suffices for this problem.
 */
public class GridDelivery {
    public static int getMinDistance(int[][] grid){
        Queue<Point> bfsQueue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int[] diffX = {0, 1, 0, -1};
        int[] diffY = {-1, 0, 1, 0};
        bfsQueue.add(new Point(0, 0, 0));
        while (!bfsQueue.isEmpty()){
            Point current = bfsQueue.poll();
            for (int i = 0; i < 4; ++i){
                int newX = current.x + diffX[i];
                int newY = current.y + diffY[i];
                if (grid[newX][newY] == 9){
                    return current.dist + 1;
                }
                if (checkInside(newX, newY, m, n) &&
                    grid[newX][newY] != 0 &&
                    !visited[newX][newY]){
                    visited[newX][newY] = true;
                    bfsQueue.add(new Point(newX, newY, current.dist + 1));
                }
            }
        }
        // Error condition.
        return -1;
    }

    static class Point{
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static boolean checkInside(int x, int y, int m, int n){
        return (x >= 0) && (y >= 0) && (x < m) && (y < n);
    }
}
