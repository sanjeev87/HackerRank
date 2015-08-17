package LeetCode;

public class FirstMissingPositive {

	public int swap(int[] nums, int index){
		int temp = nums[index];
		int num = nums[temp - 1];
		nums[temp - 1] = temp;
		nums[index] = num;
		return num;
	}
	
	public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length == 0){
			return 1;
		}
		
		for(int i = 0 ; i < nums.length ; i++){
			if(i+1 == nums[i]){
				continue;
			}else{
				int temp = nums[i];
				while(temp >= 1 && temp <= nums.length && temp != nums[temp-1]){
					temp = swap(nums,i);
				}
			}
		}
		
		for(int i = 0 ; i < nums.length ; i++){
			if(i+1 != nums[i]){
				return i+1;
			}
		}
		
		return nums.length+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
