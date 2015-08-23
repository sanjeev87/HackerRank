package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
        

		List<Integer> result = new ArrayList<Integer>();
		
		if(nums == null || nums.length == 0){
			return result;
		}
		
		if(nums.length < 3){
			for(int i : nums){
			    if(!result.contains(i)){
    				result.add(i);
			    }
			}
			return result;
		}
		
		int el1 = nums[0];
		int count1 = 0;
		int el2 = nums[1];
		int count2 = 0;
		
		for(int i = 0 ; i < nums.length ; i++){
			
			if(count1 == 0 && nums[i] != el2){
				el1 = nums[i];
				count1++;
			}else if(count2 == 0 && nums[i] != el1){
				el2 = nums[i];
				count2++;
			}else if(el1 == nums[i]){
				count1++;
			}else if(el2 == nums[i]){
				count2++;
			}else{
				count1--;
				count2--;
			}
			
		}
		
		count1 = 0;
		count2 = 0;
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i] == el1){
				count1++;
			}
			if(nums[i] == el2){
				count2++;
			}
		}
		
		if(count1 > nums.length / 3){
			if(!result.contains(el1)){
			    result.add(el1);
			}
		}
		
		if(count2 > nums.length / 3){
			if(!result.contains(el2)){
			    result.add(el2);
			}
		}
		
		
		return result;

	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
