package graphdsa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles
 * such that their centers are inside the rectangle. Radius of each circle is R. Now we need to
 * find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 *
 * Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move
 * outside the boundary of the rectangle at any point of time.
 *
 *
 * Input Format
 *
 * 1st argument given is an Integer x.
 * 2nd argument given is an Integer y.
 * 3rd argument given is an Integer N, number of circles.
 * 4th argument given is an Integer R, radius of each circle.
 * 5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
 * 6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
 * Output Format
 *
 * Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from
 * (0,0).
 * Constraints
 *
 * 0 <= x, y, R <= 100
 * 1 <= N <= 1000
 * Center of each circle would lie within the grid
 * For Example
 *
 * Input:
 *     x = 2
 *     y = 3
 *     N = 1
 *     R = 1
 *     A = [2]
 *     B = [3]
 * Output:
 *     NO
 *
 * Explanation:
 *     There is NO valid path in this case
 */
public class ValidPath {
    public static void main(String[] args){
        Point p = new Point(-1, 3);
        System.out.println(checkValidPoint(p, 4, 5));
        List<Integer> A = Arrays.asList(2);
        List<Integer> B = Arrays.asList(3);
        System.out.println(checkValidPath(2, 3, 1, 1, A, B));

    }


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int checkValidPath(int x, int y, int N, int R,
                                     List<Integer> A, List<Integer> B){
        int[] diffX = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] diffY = {1, 1, 1, 0, -1, -1, -1, 0};
        boolean[][] visited = new boolean[x+1][y+1];

        Queue<Point> bfsQueue = new LinkedList<>();
        if (checkTouchingCircle(0, 0, A, B, N, R))
            return 0;
        bfsQueue.add(new Point(0, 0));
        visited[0][0] = true;
        while (!bfsQueue.isEmpty()){
            Point current = bfsQueue.poll();
            if (checkTouchingCircle(current.x, current.y, A, B, N, R)){
                continue;
            }
            else if (current.x == x && current.y == y) return 1;
            else if (!checkValidPoint(current, x, y)) continue;
            else {
                for (int i = 0; i < 8; ++i){
                    int newX = current.x + diffX[i];
                    int newY = current.y + diffY[i];
                    Point newPoint = new Point(newX, newY);
                    if (checkValidPoint(newPoint, x, y) && !visited[newX][newY]){
                        bfsQueue.add(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return 0;
    }

    public static boolean checkValidPoint(Point p, int x, int y){
        return p.x >= 0 && p.x <= x && p.y >= 0 && p.y <= y;
    }

    public static boolean checkTouchingCircle(int posX, int posY, List<Integer> A,
                                              List<Integer> B, int N, int R){
        for (int i = 0; i < N; ++i){
            if (getDistance(posX, posY, A.get(i), B.get(i)) <= R){
                return true;
            }
        }
        return false;
    }

    public static double getDistance(int x1, int y1, int x2, int y2){
        double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return dist;
    }

}
