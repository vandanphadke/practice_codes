package Arrays;

import java.util.Collections;
import java.util.List;

public class NobleInteger {

    public int returnNobleInteger(List<Integer> arr){
        Collections.sort(arr);
        for (int i = 0; i < arr.size() - 1; ++i){
            if (arr.get(i) == arr.get(i+1))
                continue;
            else {
                if (arr.get(i) == arr.size() - i - 1)
                    return 1;
            }
        }
        return -1;
    }


}
