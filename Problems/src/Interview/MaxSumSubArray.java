package Interview;

public class MaxSumSubArray {
	
	public int maxSubArray(int[] A) {
        
		if(A== null || A.length == 0){
			return 0;
		}
		
		int max = A[0];
		int result = A[0];
		
		for(int i = 1 ; i < A.length ; i ++){
			
			max = Math.max(max + A[i], A[i]);
			
			if(max > result){
				result = max;
			}
			
		}
		
		return result;
    }

	public static void main(String[] args) {

		
	}

}
