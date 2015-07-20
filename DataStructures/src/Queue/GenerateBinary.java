package Queue;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinary {
	public static void main(String[] args) {
		int n = 7 ; 
		Queue<String> q = new LinkedList<String>();
		q.add("1");
		while(n-- != 0){
			String s = q.remove();
			System.out.println(s);
			q.add(s + "0");
			q.add(s + "1");
		}
	}
}
