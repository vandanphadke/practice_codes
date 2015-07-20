
public class ImpTricks {
	public static void main(String[] args) {
		
	}
	
	public static boolean getBit(int a,int i){
		return ((a & (1 << i)) != 0);
	}
	
	public static int setBit(int a, int i){
		return a | (1 << i);
	}
	
	public static int clearBit(int a, int i){
		int mask = ~(1 << i);
		return a & mask; 
	}
}
