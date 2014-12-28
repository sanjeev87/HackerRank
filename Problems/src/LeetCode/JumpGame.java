package LeetCode;

public class JumpGame {


	public boolean canJump(int[] A) {

		if(A.length == 1){
            return true;
        }
        
        if(A.length == 0){
            return false;
        }
		
		int[] jumps = new int[A.length];
		
		int cur = 1;
		jumps[0] = 0;
		
		for(int i = 0 ; i < A.length && (i==0 || jumps[i] > 0) ; i ++){
			for(;cur < A.length && cur <= i + A[i]; cur++){
				jumps[cur] = A[i] + 1;
			}
		}
		
		return (jumps[A.length - 1] > 0);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
