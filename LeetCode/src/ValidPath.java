import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ValidPath {

    public static void main(String[] args){
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        x.add(2);y.add(3);

        System.out.println(solve(2,3,1,1,x,y));
    }


    static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Circle {
        int x;
        int y;
        int r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }


    public static String solve(int x, int y, int N, int R, ArrayList<Integer> circX, ArrayList<Integer> circY) {
        LinkedList<Point> queue = new LinkedList<>();
        Circle[] cirles = new Circle[N];
        for (int i = 0; i < N; ++i){
            cirles[i] = new Circle(circX.get(i), circY.get(i), R);
        }

        int[][] dp = new int[x+1][y+1];
        Point start = new Point(0,0);
        queue.add(start);

        for (int i = 0 ; i <= x; ++i)
            Arrays.fill(dp[i], -1);

        dp[0][0] = 1;

        int arr1[] = {1,1,1,0,-1,-1,-1,0} ;
        int arr2[] = {-1,0,1,1,1,0,-1,-1} ;

        while (!queue.isEmpty()){
            Point current = queue.poll();
            for (int i = 0; i < 8; ++i){
                int newX = current.x + arr1[i];
                int newY = current.y + arr2[i];

                if ((newX >= 0) && (newX <= x) && (newY >= 0) && (newY <= y)){
                    if (dp[newX][newY] == -1){
                        Point newPoint = new Point(newX, newY);
                        if (checkPointNotInCircle(cirles, newPoint)){
                            queue.add(newPoint);
                            dp[newX][newY] = 1;
                        }
                        else {
                            dp[newX][newY] = 2;
                        }
                    }
                }
            }

        }

        for (int i = 0; i <= x; ++i)
            System.out.println(Arrays.toString(dp[x]));

        if(dp[x][y]==1)
            return "YES" ;

        return "NO" ;

    }


    public static boolean checkPointNotInCircle(Circle[] circles, Point p){
        for (Circle circle: circles){
            double distance = Math.sqrt(Math.pow(p.x - circle.x, 2) + Math.pow(p.y - circle.y, 2));
            if (distance < circle.r)
                return false;
        }
        return true;
    }

}
