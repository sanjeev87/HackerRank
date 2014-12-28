package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	// word break basic problem. word break II is below
	public boolean wordBreak(String s, Set<String> dict,boolean one){
		
		boolean[] solution = new boolean[s.length()+1];
		
		
		for(int i = 0 ; i <= s.length();i++){
			
			for(int j = 0; j < i ; j ++){
				
				if(j == 0 || solution[j]){
					String temp = s.substring(j, i);
					if(dict.contains(temp)){
						solution[i] = true;
					}
				}
				
				
			}
			
		}
		
		
		
		return solution[s.length()];
	}
	
	
	public static List<String> wordBreak(String s, Set<String> dict){
		
		Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();
		
		List<String> l = new ArrayList<String>();
        l.add("");
        validMap.put(0, l);
		
		for(int i = 0 ; i <= s.length() ; i ++){
			List<String> values = new ArrayList<String>();
			//values.add("");
			for(int j = 0 ; j < i ; j ++){
				if (dict.contains(s.substring(j, i))) {
					if(!validMap.get(j).isEmpty()){
						for(String word : validMap.get(j)) {
							values.add(word + (word.isEmpty() ? "" : " ") +s.substring(j, i));
						}
					}else{
						values.add(s.substring(j, i));
					}
				}
			}
			
			validMap.put(i, values);
			
		}
		return validMap.get(s.length());
		
	}
	
	
	

	public static void main(String[] args) {

		Set<String> dict = new HashSet<String>();
		dict.add("a");
		//dict.add("aaa");
		String s = "a";

		System.out.println(wordBreak(s,dict));

	}

}
