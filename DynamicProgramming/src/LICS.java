import java.util.ArrayList;
import java.util.Arrays;


public class LICS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
		LIS(arr);

	}
	
	public static int LIS(int[] arr)
	{
		int max_so_far = 0, index = 0;
		int[] L = new int[arr.length];
		
		Arrays.fill(L, 1);
		
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < i ; j++)
			{
				if(arr[i] > arr[j] && L[i] < L[j] + 1)
				{
					L[i] = L[j] + 1 ; 
					max_so_far = L[i];
					index = i ; 
				}
			}
		}
		ArrayList<Integer> li = new ArrayList<Integer>();
		
		for(int i = index ; i >= 0 ; i--)
		{
			if(L[i] == max_so_far)
			{
				li.add(arr[i]);
				max_so_far--; 
			}
		}
		System.out.println(li);
		return max_so_far;
	}

}
