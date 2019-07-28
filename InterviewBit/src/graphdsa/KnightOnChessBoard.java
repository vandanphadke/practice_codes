package graphdsa;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Knight movement on a chess board
 * Given any source point and destination point on a chess board, we need to find whether
 * Knight can move to the destination or not.
 * Knight's movements on a chess board
 * The above figure details the movements for a knight ( 8 possibilities ). Note that a
 * knight cannot go out of the board.
 * If yes, then what would be the minimum number of steps for the knight to move to the
 * said point.
 * If knight can not move from the source point to the destination point, then return -1
 *
 * Input:
 *
 * N, M, x1, y1, x2, y2
 * where N and M are size of chess board
 * x1, y1  coordinates of source point
 * x2, y2  coordinates of destination point
 * Output:
 *
 * return Minimum moves or -1
 * Example
 *
 * Input : 8 8 1 1 8 8
 * Output :  6
 */
public class KnightOnChessBoard {
    public static void main(String[] args){
        System.out.println(checkKnightMovements(2, 20, 1, 18, 1, 5));
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object point) {
            Point thisP = (Point)point;
            return thisP.x == this.x && thisP.y == this.y;
        }
    }

    static class PointDistance {
        Point point;
        int dist;

        public PointDistance(Point point, int dist) {
            this.point = point;
            this.dist = dist;
        }

        @Override
        public int hashCode() {
            return point.x * 123941 + point.y;
        }
    }

    public static int checkKnightMovements(int N, int M, int x1, int y1, int x2, int y2){
        int[] xDiff = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] yDiff = {-1, -2, -2, -1, 1, 2, 2, 1};
        if (x1 == x2 && y1 == y2) return 0;
        Point start = new Point(x1, y1);
        Queue<PointDistance> bfsQueue = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][M+1];
        bfsQueue.add(new PointDistance(start, 0));
        visited[start.x][start.y] = true;
        while (!bfsQueue.isEmpty()){
            PointDistance current = bfsQueue.poll();
            for (int i = 0; i < 8; ++i){
                int newX = current.point.x + xDiff[i];
                int newY = current.point.y + yDiff[i];
                if (newX == x2 && newY == y2) return current.dist + 1;
                if (checkInside(N, M, newX, newY) && !visited[newX][newY]){
                    Point adjacent = new Point(newX, newY);
                    visited[newX][newY] = true;
                    bfsQueue.add(new PointDistance(adjacent, current.dist + 1));
                }
            }
        }
        return -1;
    }

    public static boolean checkInside(int N, int M, int x, int y){
        return (x >= 1) && (x <= N) && (y >= 1) && (y <= M);
    }

}
