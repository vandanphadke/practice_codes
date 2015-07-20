import java.util.ArrayList;
import java.util.List;

/**
 * Q: Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * @author Vandan Phadke
 *
 */
public class MinTriangle {
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		List<Integer> b = new ArrayList<Integer>();
		b.add(3);b.add(4);
		List<List<Integer>> m = new ArrayList<List<Integer>>();
		m.add(a);m.add(b);
		System.out.println(minimumTotal(m));
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // initialize arr with the last row
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = triangle.get(n - 1).get(i);

        // bottom up comparion
        for (int i = n - 2; i >= 0; i--) 
            for (int j = 0; j <= i; j++) 
                arr[j] = Math.min(arr[j], arr[j + 1]) + triangle.get(i).get(j);

        return arr[0];
    }
}
