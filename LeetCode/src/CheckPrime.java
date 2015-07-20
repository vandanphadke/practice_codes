
public class CheckPrime {
		
	public int countPrimes(int n) {
        if(n<=2) return 0;
        boolean[] flag = new boolean[n];

        int result = 1; 

        for(int i = 3; i<n ; i = i+2){
            if(!flag[i-1]){
                result++;
                for(int k = 3; k*i < n; k = k+2){
                    if(!flag[k*i-1])
                        flag[k*i-1]= true;
                }
            }
        }
        return result;
    }
}
