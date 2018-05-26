package implementations;

import java.util.Scanner;


public class InsertionSort {
	public static void insertionSortPart2(int[] ar)
    {       
        int l = ar.length ;
        int j = 0 ; 
        int shifts = 0 ; 
        for(int i = 1 ; i < l ; i++){
            j = i - 1 ; 
            int n = ar[i];
            while(j >= 0 && ar[j] > n){
                ar[j+1] = ar[j];
                shifts+= 1 ; 
                j--;
            }
            ar[j+1] = n ; 
        }
        System.out.println(shifts);
    }  
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
}
