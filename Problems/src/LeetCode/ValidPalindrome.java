package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ValidPalindrome {


	public boolean isPalindrome(String s) {
		
		if(s.isEmpty()){
			return true;
		}
		
		s = s.replaceAll("[^A-Za-z0-9]", "");
		s = s.toLowerCase();
		
		for(int i = 0 ; i < s.length() ; i ++){
			
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
			
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
