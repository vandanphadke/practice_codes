import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		int[] num = new int[]{0,1,2,4,2,7};
		int k = 2 ; 
		System.out.println(containsNearbyDuplicate(num, k));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0 ; i < nums.length ; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
                System.out.println(map);
            }
            
            else{
                int diff = Math.abs(i - map.get(nums[i]));
                if(diff <= k)
                    return true;
                map.put(nums[i], i);
                System.out.println(map);
            }
        }

        return false; 

    }
}
