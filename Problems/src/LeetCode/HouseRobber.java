package LeetCode;

public class HouseRobber {
	
	
	public int rob(int[] nums) {

		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int[] result = new int[nums.length + 1];
		result[1] = nums[0];
		
		for(int i = 1 ; i < nums.length ; i++){
			result[i+1] = Math.max(nums[i] + result[i-1], result[i]);
		}
		
		return result[nums.length];
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
