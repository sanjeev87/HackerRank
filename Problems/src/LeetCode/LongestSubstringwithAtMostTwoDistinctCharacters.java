package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
        

		if(s == null || s.isEmpty()){
			return 0;
		}
		
		int best = 0;
		Set<Character> chars = new HashSet<Character>();
		int start = 0;
		int i = 0;
		int prevIndex = 0;
		while(i < s.length()){
			if(chars.contains(s.charAt(i))){
				i++;
			}else if(chars.size() == 1 && !chars.contains(s.charAt(i))){
				prevIndex = i;
				chars.add(s.charAt(i));
				i++;
			}else if(chars.size() > 1 && !chars.contains(s.charAt(i))){
				
				if(i - start > best){
					best = i - start;
				}
				i = prevIndex;
				chars.clear();
				start = prevIndex;
			}else if(chars.size() == 0){
				chars.add(s.charAt(i));
				i++;
			}
			
		}
		
		if(i - start > best){
			best = i - start;
		}
		
		
		return best;
	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LongestSubstringwithAtMostTwoDistinctCharacters l = new LongestSubstringwithAtMostTwoDistinctCharacters();
		
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("abace"));

	}

}
