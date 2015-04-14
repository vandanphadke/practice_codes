
public class zerooneknapsack {
	public static void main(String[] args) {
		int[] val = {60, 100, 120};
	    int[] wt = {10, 20, 30};
	    int  W = 50;
	    
		System.out.println(knapSack(wt, val, W));
	}
	
	public static int knapSack(int weight[], int val[], int totalWeight)
	{
		
		if(weight.length != val.length)
			throw new IllegalArgumentException("Incorrect no of weight or values");
		int no_of_items = weight.length ; 
		
		int[][] sack = new int[no_of_items + 1][totalWeight + 1];
		
		for(int i = 0 ; i <= no_of_items ; i++)
		{
			for(int j = 0 ;  j <= totalWeight ; j++)
			{
				if(i == 0 || j == 0)
					sack[i][j] = 0 ; 
				
				
			}
		}
		
		return sack[no_of_items][totalWeight]; 
	}
	
	public static int max(int a, int b)
	{
		if(a > b) 	return a ;
		else 	return b ;
	}
}
