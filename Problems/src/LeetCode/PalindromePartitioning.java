package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	
	public void partitionHelper(String s , int start, List<String> list, List<List<String>> result){
		
		if(start == s.length()){
			result.add(new ArrayList<String>(list));
			return;
		}
		
		for(int i = start + 1 ; i <= s.length() ; i ++){
			String str = s.substring(start, i);
			if(isPalindrome(str)){
				list.add(str);
				partitionHelper(s, i, list, result);
				list.remove(list.size() - 1);
			}
			
		}
		
		
	}
	
	public boolean isPalindrome(String s){
		int i = 0;
		int j = s.length() - 1;
		
		while(i < j){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public List<List<String>> partition(String s) {

		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		
		
		partitionHelper(s, 0, list, result);
		
		return result;
	}


	public static void main(String[] args) {


	}

}
