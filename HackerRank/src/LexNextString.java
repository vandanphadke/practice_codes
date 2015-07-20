import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LexNextString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int no = 0 ; 
		try{
            	no = Integer.parseInt(in.readLine());
            	for(int i = 0 ; i < no ; i++)
            	{
            		String input = in.readLine();
            		for(int j = (input.length()-1) ; j >=0 ; j++)
            		{
            			
            		}
            	}
         
		}catch(IOException e){e.printStackTrace();}

	}

}
