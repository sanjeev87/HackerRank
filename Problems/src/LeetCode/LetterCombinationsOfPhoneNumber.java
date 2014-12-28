package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LetterCombinationsOfPhoneNumber {


	public void letterCombinationHelper(String digits, int length
			, int digitIndex, List<String> result
			, Map<Character,String> map, Stack<Character> stack){
		
		if(digitIndex == length){
			return;
		}
		
		String letters = map.get(digits.charAt(digitIndex));
		
		for(int i = 0 ; i < letters.length() ; i ++){
			
			stack.push(letters.charAt(i));
			
			if(stack.size() == length){
				char[] array = new char[length];
				int k = 0;
				for(char c : stack){
					array[k++] = c;
				}
				result.add(new String(array));
			}
			
			letterCombinationHelper(digits, length, digitIndex+1, result, map, stack);
			stack.pop();
			
		}
		
		
	}
	
	
	public List<String> letterCombinations(String digits) {

		List<String> result = new ArrayList<String>();
		
		Map<Character,String> map = new HashMap<Character, String>();
		
		Stack<Character> stack = new Stack<Character>();
		
		if(digits.length() == 0){
			result.add("");
			return result;
		}
		
		map.put('1', "");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		
		int length = 0;
		for(int i = 0 ; i < digits.length() ; i ++){
			length += map.get(digits.charAt(i)).length() > 0 ? 1 : 0;
		}
		
		letterCombinationHelper(digits, length, 0, result, map , stack);
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
