package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	
	public boolean isUnitDistAway(String s1, String s2){
		
		int numMistMatch = 0;
		
		for(int i =0 ; i < s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				numMistMatch++;
				if(numMistMatch > 1){
					return false;
				}
			}
		}
		
		return numMistMatch <= 1;
		
	}
	
	public List<String> getNeighbors(String str, Set<String> dict){
		
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < str.length() ; i++){
			for(int j = 0 ; j < 26 ;j ++){
				StringBuilder sb = new StringBuilder(str);
				char c = (char) ('a' + j);
				if(str.charAt(i) != c){
					sb.setCharAt(i, c);
					String s = sb.toString();
					if(dict.contains(s)){
						result.add(s);
					}
				}
			}
		}
		
		return result;
	}
	
	public int ladderLength(String start, String end, Set<String> dict) {

		Queue<String> wordQueue = new LinkedList<String>();
		Queue<Integer> levelQueue = new LinkedList<Integer>();
		Set<String> wordAccounted = new HashSet<String>();
	
		for(String str : getNeighbors(start,dict)){
			wordQueue.add(str);
			levelQueue.add(2);
			wordAccounted.add(str);
		}
		
		String cur = start;
		int result = 0;
		
		if(isUnitDistAway(cur, end) && dict.contains(cur)){
			return 2;
		}

		while(!wordQueue.isEmpty() && !levelQueue.isEmpty()){
			
			cur = wordQueue.remove();
			result = levelQueue.remove();
			
			if(isUnitDistAway(cur, end) && dict.contains(cur)){
				return result+1;
			}
			
			
			for(String str : getNeighbors(cur,dict)){
				if(!wordAccounted.contains(str)){
					wordQueue.add(str);
					levelQueue.add(result+1);
					wordAccounted.add(str);
				}
			}
			
		}
		
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
