import java.util.ArrayList;
import java.util.HashMap;

public class PointsOnStraightLine {



    public static int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        if (x.size() == 0)
            return 0;

        Point[] points = new Point[x.size()];
        for (int i = 0 ; i < x.size(); ++i){
            points[i] = new Point(x.get(i), y.get(i));
        }
        
        return findMaxPointsSlope(points);

    }

    private static int findMaxPointsSlope(Point[] points) {
        int maxPoints = Integer.MIN_VALUE;
        HashMap<Double, Integer> finalResult = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int duplicates = 1;
            int infinity = 0;
            Point x1 = points[i];
            for (int j = i+1; j < points.length; ++j){
                Point x2 = points[j];
                if (x1.x == x2.x){
                    if (x1.y == x2.y)
                        ++duplicates;
                    else
                        ++infinity;
                }
                else {
                    double slope = getSlope(x1, x2);
                    finalResult.put(slope, finalResult.getOrDefault(slope, 0) + 1);
                }
            }

            for (Integer value: finalResult.values()){
                if (value + duplicates > maxPoints){
                    maxPoints = value + duplicates;
                }
            }
            maxPoints = Math.max(infinity + duplicates, maxPoints);
            finalResult.clear();
        }

        return maxPoints;

    }

    private static double getSlope(Point p1, Point p2){
        if (p1.y == p2.y)
            return 0.0;
        else
            return (1.0 * (p2.y - p1.y)) / (p2.x - p1.x);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}