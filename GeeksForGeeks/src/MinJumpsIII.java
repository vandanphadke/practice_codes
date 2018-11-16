import java.util.Arrays;

public class MinJumpsIII {

    public static void main(String[] args){
        int[] cost = {1, 2, 4, -1, 2};
        int b = 1;

        System.out.println(getMinCostPath(cost, b));
        //getMinCostPath(cost, b);
    }

    private static int getMinCostPath(int[] cost, int b) {
        int n = cost.length;
        int[] pathCost = new int[n];
        pathCost[0] = cost[0];

        for (int i = 1; i < n; ++i){
            if (cost[i] == -1)
                pathCost[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n; ++i) {
            int min_cost = Integer.MAX_VALUE;
            if (cost[i] != -1) {
                for (int j = 1; j <= b; ++j) {
                    int index = i - j;
                    if (index >= 0 && pathCost[index] < Integer.MAX_VALUE) {
                        int current_cost = pathCost[index] + cost[i];
                        if (current_cost < min_cost) {
                            min_cost = current_cost;
                        }
                    }
                }
                pathCost[i] = min_cost;
            }
        }
        System.out.println(Arrays.toString(pathCost));
        return pathCost[n-1];

    }


}
