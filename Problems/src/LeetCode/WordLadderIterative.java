package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderIterative {


	public boolean isOneAway(String s1, String s2){
		int numMismatch = 0;
		for(int i = 0 ; i < s1.length() ; i++){
			if(s1.charAt(i)!= s2.charAt(i)){
				numMismatch++;
			}
		}
		return numMismatch <= 1;
	}


	public Set<String> getNeighbor(String str,Set<String> wordDict){
		Set<String> result = new HashSet<String>();
		for(int i = 0 ; i < str.length() ; i++){
			for(int j = 0 ; j < 26 ; j++){
				char c = (char) ('a' + j) ;
				StringBuilder tmp = new StringBuilder(str);
				if(str.charAt(i) != c){
					tmp.setCharAt(i, c);
					String s = tmp.toString();
					if(wordDict.contains(s)){
						result.add(s);
					}
				}
			}
		}
		return result;
	}

	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {

		Queue<String>   wordQueue = new LinkedList<String>();
		Queue<Integer> levelQueue = new LinkedList<Integer>();
		Set<String> wordUsed = new HashSet<String>();

		if(isOneAway(beginWord,endWord)){
			return 2;
		}

		for(String word: getNeighbor(beginWord, wordDict)){
			if(!wordUsed.contains(word)){
				wordQueue.add(word);
				levelQueue.add(2);
				wordUsed.add(word);
			}
		}

		while(!wordQueue.isEmpty()){
			String word = wordQueue.remove();
			int level = levelQueue.remove();

			if(isOneAway(word,endWord)){
				return level+1;
			}

			for(String w: getNeighbor(word, wordDict)){
				if(!wordUsed.contains(w)){
					wordQueue.add(w);
					levelQueue.add(level + 1);
					wordUsed.add(w);
				}
			}

		}

		return 0;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
