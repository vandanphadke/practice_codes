import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UnorderedAnagrams {
	
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			int no = Integer.parseInt(in.readLine());
			for(int i = 0 ; i < no ; i ++)
			{
				String input = in.readLine();
				
				
				
			}	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
