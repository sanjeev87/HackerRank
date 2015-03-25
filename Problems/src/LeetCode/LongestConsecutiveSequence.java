package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {


	public int longestConsecutive(int[] num) {
		
		int longest = 0;
		Map<Integer,Integer> map  = new HashMap<Integer, Integer>();

		for(int i = 0 ; i < num.length ; i++){

			if(!map.containsKey(num[i])){
				map.put(num[i], 1);
			}else{
				continue;
			}
			
			int begin = num[i];
			int end = num[i];
			
			if(map.containsKey(num[i]+1)){
				end = num[i] + map.get(num[i]+1);
			}
			
			if(map.containsKey(num[i]-1)){
				begin = num[i] - map.get(num[i] - 1);
			}
			
			int length = end - begin + 1;
			if(length > longest){
				longest = length;
			}
			map.put(begin, length);
			map.put(end, length);
			
		}
		
		return longest;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
