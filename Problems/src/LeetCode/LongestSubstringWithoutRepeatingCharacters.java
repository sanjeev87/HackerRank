package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		
		if(s == null || s.length() == 0){
			return 0;
		}
		
		int best = 0;
		int start = -1;
		Map<Character,Integer> set = new HashMap<Character, Integer>();
		
		for(int i = 0 ; i < s.length() ; i++){
			if(set.containsKey(s.charAt(i))){
				start = Math.max(start, set.get(s.charAt(i)));
			}
			int length = i -start;
			if(length > best){
				best = length;
			}
			set.put(s.charAt(i), i);
		}
		
		
		return best;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
