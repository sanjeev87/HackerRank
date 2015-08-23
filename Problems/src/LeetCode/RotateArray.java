package LeetCode;

public class RotateArray {

	public void rotate(int[] nums, int k) {

		k = k % nums.length;
		
		int swapIndex = 0;
		int swapFromBuf = nums[swapIndex];
		int swapToBuf = 0;
		int cycleStartIndex = 0;
	
		
		for(int i = 0 ; i < nums.length ;i++){
			
			swapIndex = (swapIndex + k) % nums.length;
			
			// swap
			swapToBuf = nums[swapIndex];
			nums[swapIndex] = swapFromBuf;
			swapFromBuf = swapToBuf;
			
			if(swapIndex == cycleStartIndex){
				cycleStartIndex++;
				swapIndex = cycleStartIndex % nums.length;
				swapFromBuf = nums[swapIndex];
			}
			
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
