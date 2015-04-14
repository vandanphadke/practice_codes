
public class MaxContSubArr {
	public static void main(String[] args) {
		int[] inp = new int[]{1,-3,4,-2,-1,6};
		System.out.println(maxArray(inp));
	}
	
	public static int maxArray(int[] input)
	{
		int max = 0 ;
		int[] window = new int[input.length];
		
		if(input[0] > 0) window[0] = input[0];
		else	window[0] = 0 ; 
		
		for(int i = 1 ; i < input.length ; i++)
		{
			if(window[i-1] + input[i] > 0){
				window[i] = window[i-1] + input[i] ;
				if(window[i] > max)	max = window[i] ;
			}
			else
				window[i] = 0 ; 
		}
		
		
		return max ; 
	}
}
