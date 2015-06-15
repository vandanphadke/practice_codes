import java.util.Arrays;


public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = new int[]{7,3,4,5,1,2,59,0 };
		n = selectionsort(n);
		System.out.println(Arrays.toString(n));
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
	
	public static int[] selectionsort(int[] data){
		for(int i = 0 ; i < data.length - 1 ; i++){
			int min = i ; 
			for(int j = i ; j < data.length ; j++ ){
				if(data[j] < data[min])
					min = j ;
			}
			int temp = data[min];
			data[min] = data[i];
			data[i] = temp ;
		}
		return data;
	}

}
