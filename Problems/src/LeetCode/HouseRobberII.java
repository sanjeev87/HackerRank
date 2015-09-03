package LeetCode;

public class HouseRobberII {

	public int helper(int[] nums, int start, int end) {

		if(nums == null || nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return nums[0];
		}
		if(nums.length == 2){
			return Math.max(nums[0],nums[1]);
		}
		int[] result = new int[end - start + 2];
		result[1] = nums[start];
		for(int i = start+1 ; i <= end ; i++){
			result[i-start+1] = Math.max(nums[i] + result[i-start-1], result[i-start]);
		}
		
		return result[result.length-1];
	}

	public int rob(int[] nums) {

		return Math.max(helper(nums, 0, nums.length - 2),helper(nums, 1, nums.length - 1));
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
