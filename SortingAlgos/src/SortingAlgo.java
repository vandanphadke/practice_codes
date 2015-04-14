
public class SortingAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = new int[]{7,3,4,5,1,2,59,0 };
		Quicksort  merge = new Quicksort();
		merge.sort(n);
		for(int i = 0 ; i < n.length ; i++)
			System.out.print(n[i] + " ");
		System.out.println();
	}
	
	//Iterate from first to last and swap if needed
	public static int[] bubblesort(int[] data)
	{
		for(int i = data.length  ; i >= 0 ; i--)
		{
			for(int j = 0 ; j < i - 1 ; j++)
			{
				if(data[j] > data[j+1])
				{
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp ; 
				}
			}
		}
		return data;
	}

}
