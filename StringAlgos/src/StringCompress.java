
public class StringCompress {
	public static void main(String[] args) {
		char[] inp = new String("aaaabbcccddaaaccc").toCharArray();
		
		int i = 0;
		while(i < inp.length){
			int j = i + 1, count = 1;
			while(j < inp.length && inp[i] == inp[j]){
				++count;
				j++;
			}
			System.out.print((char)inp[i] + "" + count);
			i = j;
		}
	}
}
