package LeetCode;

public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int s, int[] nums) {
    	int minSubArrayLength = Integer.MAX_VALUE;
    	int index = 0;
    	int sum = 0;
    	int i = 0;
    	while( i < nums.length){
    		sum += nums[i];
    		while(index < nums.length && sum >= s){
    			minSubArrayLength = Math.min(minSubArrayLength, i - index + 1);
    			sum -= nums[index];
    			index++;
    		}
    		i++;
    	}
    	return minSubArrayLength == Integer.MAX_VALUE ? 0 : minSubArrayLength;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
