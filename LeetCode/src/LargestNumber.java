import java.util.Arrays;
import java.util.Comparator;


public class LargestNumber {

	public  String largestNumber(int[] nums) {
        String result = "";
        if (nums == null || nums.length == 0) return result; // special case
        Integer[] copy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) copy[i] = nums[i];
        Arrays.sort(copy, new NumComparator()); // sort
        if (copy[copy.length - 1] == 0) return "0"; // if all element is 0, return "0"
        for (int i = copy.length - 1; i >= 0; i--) result += String.valueOf(copy[i]);
        return result;
    }
	
	class NumComparator implements Comparator<Integer> {
	    @Override
	    public int compare(Integer i1, Integer i2) {
	        String s1 = String.valueOf(i1) + String.valueOf(i2);
	        String s2 = String.valueOf(i2) + String.valueOf(i1);
	        for (int i = 0; i < s1.length(); i++) {
	            if (s1.charAt(i) > s2.charAt(i)) return 1;
	            if (s1.charAt(i) < s2.charAt(i)) return -1;
	        }
	        return 0;
	    }
	}
}
