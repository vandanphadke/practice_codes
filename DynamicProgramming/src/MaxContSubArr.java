public class MaxContSubArr {
	public static void main(String[] args) {
		int[] inp = new int[]{1,-3,4,-2,-1,6};
		System.out.println(maxArrayContiguous(inp));
	}
	
	//Select elements which are contiguous
	public static int maxArrayContiguous(int[] input)
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
	
	//Select elements which are non-contiguous
	public static int maxArrayNonContiguous(int[] input)
	{
		int max = 0 ;
		
		int[] window = new int[input.length];
		window[0] = input[0] ; 
		window[1] = (input[0] > input[1]?input[0]:input[1]);
		
		for(int i = 2 ; i < input.length ; i++)
		{
			if(window[i-1] > (window[i-2] + input[i]))
				window[i] = window[i-1];
			else
				window[i] = (window[i-2] + input[i]);
		}
		
		return window[input.length - 1] ; 
	}
}
