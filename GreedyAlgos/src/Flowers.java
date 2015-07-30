import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Q: You and your K-1 friends want to buy N flowers. Flower number i has cost ci. 
 * Unfortunately the seller does not want just one customer to buy a lot of flowers, 
 * so he tries to change the price of flowers for customers who have already bought 
 * some flowers. More precisely, if a customer has already bought x flowers, he should pay 
 * (x+1)*ci dollars to buy flower number i.
 * You and your K-1 friends want to buy all N flowers in such a way that you spend the least amount of money. You can buy the flowers in any order.
 * @author Vandan Phadke
 *
 */
public class Flowers {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		int[] arr = new int[n];
		line = in.readLine().split(" ");
		int sum = 0, count = 0; 
		for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(line[i]);
		if(n == k){
			for(int i: arr)
				sum += i;
			System.out.println(sum);
			return;
		}
		Arrays.sort(arr);
		int i = n - 1; 
		for(; i >= k ; i = i - k){
			for(int j = 0 ; j < k ; j++)
				sum += (count + 1)*(arr[i-j]);
			++count;
		}
		for(int j = 0 ; j <= i ; j++)
			sum += (count + 1)*(arr[i-j]);
		System.out.println(sum);
	}
}
