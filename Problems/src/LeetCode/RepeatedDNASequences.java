package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {
		
		Set<Integer> words = new HashSet<Integer>();
		Set<Integer> repeatedWords = new HashSet<Integer>();
		List<String> result = new ArrayList<String>();
		
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		for(int i = 0 ; i < s.length() - 9 ; i ++){

			int num = 0;
			for(int j = i ; j < i + 10 ; j++){
				num |= map.get(s.charAt(j));
				num <<= 2;
			}
			
			if(!words.add(num) && repeatedWords.add(num)) {
	            result.add(s.substring(i, i + 10));
	        }
		}
		
		return result;
	}

	public static void main(String[] args){
		
		int temp1 = 0;
		int temp2 = 3;
		
		temp1 <<= 2;
		temp2 <<= 2;
		
		char c = 3;
		int i = 0 | c;
		i <<= 2;
		
		
		char[] arr = new char[10];
		
		System.out.println(Integer.toBinaryString(arr[1]));
		
	}
	
	
}
