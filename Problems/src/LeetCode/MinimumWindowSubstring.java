package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public String minWindow(String S, String T) {
		
		int start = -1;
		int end = S.length();
		int counter = 0;
				
		Map<Character,Integer> expected = new HashMap<Character,Integer>();
		Map<Character,Integer> window = new HashMap<Character,Integer>();
		
		for(int i = 0; i < T.length() ; i++){
			if(!expected.containsKey(T.charAt(i))){
				expected.put(T.charAt(i), 0);
			}
				expected.put(T.charAt(i), expected.get(T.charAt(i)) + 1);

		}
		
		for(int i = 0 , j = 0 ; i < S.length() ; i++){
			
			char cur = S.charAt(i);
			
			if(expected.containsKey(cur)){
				if(!window.containsKey(cur)){
					window.put(cur, 0);
				}
				window.put(cur,(window.get(cur) + 1));
				if(window.get(cur) <= expected.get(cur)){
					counter++;
				}
				if(counter == T.length()){
					char remove = S.charAt(j);
					while(!window.containsKey(remove) || 
							window.get(remove) > expected.get(remove)){
						if(window.containsKey(remove)){
							window.put(remove,(window.get(remove) - 1));
						}
						remove = S.charAt(++j);
					}
					
					if(i - j < end - start){
						end = i;
						start = j;
					}
					
				}
				
				
			}
			
			
		}
		

		return end - start < S.length() + 1 ? S.substring(start,end + 1) : "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
