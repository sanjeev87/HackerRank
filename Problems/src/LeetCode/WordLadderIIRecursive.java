package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/*
 * this solution is not good enough to pass the online judge 
 * this is too slow. 
 */
public class WordLadderIIRecursive {

	public boolean isOneAway(String s1, String s2){

		int numMismatch = 0;
		for(int i = 0 ; i < s1.length() ; i++){
			if(s1.charAt(i)!= s2.charAt(i)){
				numMismatch++;
			}
		}

		return numMismatch <= 1;
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

	public List<List<String>> findLadders(String start, String end, Set<String> wordList) {

		List<List<String>> result = new ArrayList<List<String>>();
		List<String> cur = new ArrayList<String>();
		cur.add(start);

		Map<String,Boolean> used = new HashMap<String, Boolean>();

		
		for(String word : wordList){
			used.put(word, false);
		}

		findLadders(start, end, wordList, result, cur, used);

		return result;
	}


	public void findLadders(String start, String end, 
			Set<String> wordList,List<List<String>> result,List<String> cur,Map<String,Boolean> used){

		if(isOneAway(start, end)){
			cur.add(end);
			result.add(new ArrayList<String>(cur));
			cur.remove(end);
		}
		List<String> neighbor = getNeighbors(start,wordList);
		for(String word : neighbor){
			if(used.containsKey(word) && !used.get(word) && isOneAway(start,word)){
				cur.add(word);
				used.put(word, true);
				findLadders(word, end, wordList, result, cur, used);
				cur.remove(word);
				used.put(word, false);
			}
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
