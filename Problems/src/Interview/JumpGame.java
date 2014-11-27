package Interview;

public class JumpGame {

	 public int jump(int[] A) {
	     
		 int[] result = new int[A.length];
		 
		 for(int i = 0 ; i < result.length ; i ++){
			 result[i] = Integer.MAX_VALUE;
		 }
		 
		 result[0] = 0;
		 
		 for(int i = 0 ; i < A.length ; i ++){
			 for(int j = Math.min(A[i],A.length) ; j > 0 ; j--){
				 if(i+j < result.length - 1){
					 result[i+j] = Math.min(result[i] + 1, result[i+j]);
				 }
			 }
			 
		 }
		 
		 return result[A.length-1];
	 }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
