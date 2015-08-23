package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c : s.toCharArray()){
			if(!map.containsKey(c)){
				map.put(c, 1);
			}else{
				map.put(c, map.get(c)+1);
			}
		}
		
		for(char c : t.toCharArray()){
			if(!map.containsKey(c)){
				return false;
			}else{
				map.put(c, map.get(c)-1);
			}
		}
		
		for(int i : map.values()){
			if(i != 0){
				return false;
			}
		}
		
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
