package LeetCode;

import java.util.HashSet;
import java.util.Set;

/*
 * this recursive solution does not pass the OJ.
 * Looks like solution needs to be iterative to be fast enough to pass OJ
 */
public class WordLadderRecursion {

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
	
	public int ladderLengthHelper(String beginWord, String endWord, Set<String> wordDict
			,Set<String> wordsUsed,int level) {
		
		if(isOneAway(beginWord,endWord)){
			return level+1;
		}
		
		Set<String> neighbor = getNeighbor(beginWord, wordDict);
		for(String word : neighbor){
			if(!wordsUsed.contains(word)){
				wordsUsed.add(word);
				int len = ladderLengthHelper(word, endWord, wordDict, wordsUsed, level + 1);
				if(len != -1){
					return len;
				}
				wordsUsed.remove(word);
			}
		}
		
		return -1;
		
	}
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		
		if(isOneAway(beginWord,endWord)){
			return 2;
		}
		Set<String> wordsUsed = new HashSet<String>();
		wordsUsed.add(beginWord);
		int len = ladderLengthHelper(beginWord, endWord, wordDict, wordsUsed , 2);
		
		return len == -1 ? 0 : len;
	}

}
