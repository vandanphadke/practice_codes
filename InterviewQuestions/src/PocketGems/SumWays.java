package PocketGems;

import java.util.HashMap;

public class SumWays {

    static HashMap<String, Integer> store = new HashMap<>();

    public static int partition(int n, int max) {
        String key = n + "" + max;
        if (n == 0 || n == 1) {
            return 1;
        }
        else if (store.containsKey(key)){
            return store.get(key);
        }
        else {
            int count = 0;
            for (int i = Math.min(max, n); i >= 1; i--) {
                count += partition(n-i, i) % 100000007;
            }
            store.put(key, count);
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(partition(10000, 4));
    }
}
