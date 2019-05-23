package PocketGems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PredatorGroups {
    public static void main(String[] args){
        getPredatorGroups();
    }

    public static void getPredatorGroups(){
        Integer[] predators = {4, 8, 6, 0, 7, 3, 8, 9, -1, 6};
        List<Integer> preds = Arrays.asList(predators);
        int maxDepth = Integer.MIN_VALUE;
        for (int i = 0; i < predators.length; ++i){
            if (getDepth(preds, i) > maxDepth)
                maxDepth = getDepth(preds, i);
        }
        System.out.println(maxDepth);
    }

    static HashMap<Integer, Integer> store = new HashMap<>();

    public static int getDepth(List<Integer> predators, int index){
        if (predators.get(index) == -1)
            return 1;
        else {
            if (store.containsKey(index))
                return store.get(index);
            else {
                int myDepth = 1 + getDepth(predators, predators.get(index));
                store.put(index, myDepth);
                return myDepth;
            }
        }

    }

}
