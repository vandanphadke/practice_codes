import java.util.ArrayList;
import java.util.Collections;


public class CountNumberOfOnes {
	public static void main(String[] args) {
		System.out.println(countDigitOne(13));
	}
	
	public static int countDigitOne(int n) {
		ArrayList<Integer> e = new ArrayList<Integer>();
        int no = n ;
        while(no > 0){
        	e.add(no%10);
            no = no / 10 ;
        }
        Collections.reverse(e);
        int count ; 
        if(n > 1)
        	count = 1 ;
        else{
        	return 0 ; 
        }
        for(int i = 0 ; i < e.size() ; i++){
        	if(e.get(i) > 1){
        		count += Math.pow(10, e.size() - i - 1);
        	}
        	else if(e.get(i) == 1){
        		int temp = 0 ; 
        		for(int j = i + 1 ; j < e.size() ; j++){
        			temp = temp * 10 + e.get(j);
        		}
        		count += temp + 1;
        	}
        	else if(i == 0)
        		continue;
        }
        return count ; 
    }
}
