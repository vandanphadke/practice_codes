
public class PivotedBinarySearch {
	public static void main(String[] args) {
		int[] in = new int[]{4,5,6,7,1,2,3};
		int index = seachPivoted(in, 6);
		System.out.println(index);
	}

	private static int seachPivoted(int[] A, int key) {
		int L = 0;
		int R = A.length - 1;
		while( L <= R){
			int M = L + ((R - L) / 2);
			
			if (A[M] == key) return M;
			
			// the bottom half is sorted
		    if (A[L] <= A[M]) {
		      if (A[L] <= key && key < A[M])
		        R = M - 1;
		      else
		        L = M + 1;
		    }
		    // the upper half is sorted
		    else {
		      if (A[M] < key && key <= A[R])
		        L = M + 1;
		      else 
		        R = M - 1;
		    }
		  }
		  return -1;
	}
	
}
