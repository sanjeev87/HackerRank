package LeetCode;

public class TrappingRainWater {

	public int trap(int[] A) {
		
		if(A.length <= 1 ){
            return 0;
        }

		int[] level = new int[A.length];
		int[] leftMax = new int[A.length];
		int[] rightMax = new int[A.length];
		
		for(int i = 0 ; i < A.length ; i ++){
			int j = A.length - 1 - i;
			if(i == 0){
				leftMax[i] = A[i];
				rightMax[j] = A[j];
			}else{
				leftMax[i] = Math.max(A[i], leftMax[i-1]);
				rightMax[j] = Math.max(A[j], rightMax[j+1]);
			}
		}
		
		int water = 0;
		for(int i = 0 ; i < A.length ; i ++){
			level[i] = Math.min(leftMax[i], rightMax[i]);
			water += level[i] - A[i];
		}
		
		
		return water;
	}
	
	public static void main(String[] args){
		
		TrappingRainWater t = new TrappingRainWater();
		
		int[] A = new int[3];
		
		A[0] = 0;
		A[1] = 2;
		A[2] = 0;
		
		
		System.out.println(t.trap(A));
		
		
	}

}
