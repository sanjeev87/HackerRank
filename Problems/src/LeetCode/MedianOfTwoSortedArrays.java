package LeetCode;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {
		
		int m = A.length;
		int n = B.length;
		
		int k = (m+n+1)/2;
		
		double median = findKth(A, 0, m-1, B, 0, n-1, k);
		
		if( (m+n) % 2 == 0){
			median += findKth(A, 0, m-1, B, 0, n-1, k+1);
			median = median /2;
		}

		return median;
	}
	
	
	public double findKth(int A[], int aL, int aR, int B[], int bL, int bR, int k){
		
		if(aL > aR){
			return B[bL+ k-1];
		}
		
		if(bL > bR){
			return A[aL + k -1];
		}
		
		
		int aMid = (aL + aR)/2;
		int bMid = (bL + bR)/2;
		
		if(A[aMid] <= B[bMid]){
			
			if(k <= aMid - aL + bMid - bL + 1){
				return findKth(A, aL,aR, B, bL, bMid - 1, k);
			}else{
				return findKth(A, aMid+1, aR, B, bL, bR, k- (aMid - aL) - 1);
			}
			
		}else{
			
			if(k <= aMid - aL + bMid - bL + 1){
				return findKth(A, aL,aMid-1, B, bL, bR, k);
			}else{
				return findKth(A, aL, aR, B, bMid + 1, bR, k- (bMid - bL) - 1);
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
