package Stack;

import java.util.Stack;

/**
 * Q: Given n non-negative integers representing an elevation map where the width of each 
 * bar is 1, compute how much water it is able to trap after raining.

   For example, 
   Given [0,1,0,2,1,0,1,3,2,1,2,1], return 
 * @author Vandan Phadke
 *
 */
public class TrappingRainWater {
	public static void main(String[] args) {
		int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(getTrapArea(arr));
	}
	
	public static int getTrapArea(int[] arr){
		if(arr.length < 2)
			return 0; 
		int total_area = 0, area = 0; 
		int i = 0 ; 
		while(arr[i] == 0)
			++i;
		int j = i, k = i + 1 ;
		while(k != arr.length){		
			if(arr[k] < arr[j]){
				area += arr[j] - arr[k];
				++k;
				//System.out.println(k + "  " + area);
			}
			else{
				total_area += area; 
				area = 0 ;
				j = k ;
				++k;
			}
		}
		--k;
        if(arr[k] < arr[j]){
            int t = k-1;
            while(k != j){
                if(arr[t] < arr[k]){
                    total_area += (arr[k] - arr[t]);
                    t--;
                }else{
                    k = t;
                    t--;
                }
            }
        }
		return total_area;
	}
}
