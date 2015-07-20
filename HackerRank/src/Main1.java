import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Main1 {
	public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        s.replace(" ", "");
        int l = s.length();        
        int sqrt = (int)Math.sqrt(l);
        int i = 0, j = 0; 
        if(sqrt*sqrt == l){
        	i = sqrt;
        	j = sqrt;
        }
        else{
        	i = sqrt; 
        	j = sqrt + 1 ;
        }
        	
        char[][] inp = new char[j][j];
        
        for(int i1 = 0 ; i1 < j ; i1++)
        	for(int i2 = 0 ; i2 < j ; i2++){
        		if(j*i1 + i2 < s.length())
        			inp[i1][i2] = s.charAt(j*i1 + i2);
        		else
        			inp[i1][i2] = ' ';
        	}
        
        for(int i1 = 0 ; i1 < i ; i1++)
        {
        	for(int i2 = 0 ; i2 < j ; i2++)
        		System.out.print((char)inp[i1][i2] + "\t");
        	System.out.println();
        }
        
        
    }
    
}
