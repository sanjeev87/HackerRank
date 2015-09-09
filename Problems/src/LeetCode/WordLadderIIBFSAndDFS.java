package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderIIBFSAndDFS {

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

		Queue<String> wordQueue = new LinkedList<String>();
		wordQueue.add(start);
		Set<String> wordsUsed = new HashSet<String>();
		wordsUsed.add(start);
		wordList.add(end);
		Map<String,List<String>> incoming = new HashMap<String, List<String>>();

		// build the incoming map 
		while(!wordQueue.isEmpty()){
			String word = wordQueue.remove();
			if(word.equals(end)){
				break;
			}
			
			List<String> neighbors = getNeighbors(word, wordList);
			if(neighbors.contains(end)){
				neighbors.clear();
				neighbors.add(end);
			}
			
			for(String neigh : neighbors){
				if(neigh.equals(end) || !wordsUsed.contains(neigh)){
					wordsUsed.add(neigh);
					if(!incoming.containsKey(neigh)){
						incoming.put(neigh, new ArrayList<String>());
					}
					incoming.get(neigh).add(word);
					wordQueue.add(neigh);
				}
			}
		}

		//DFS the incoming map to get all the paths
		buildPathsDFS( end,  start,  incoming, result,new ArrayList<String>());

		return result;
	}

	public void buildPathsDFS(String start, String end, Map<String,
			List<String>> incoming,List<List<String>> result,List<String> curPath){

		if(start.equals(end)){
			curPath.add(end);
			List<String> temp = new ArrayList<String>(curPath);
			Collections.reverse(temp);
			result.add(temp);
			curPath.remove(end);
			return;
		}

		if(incoming.containsKey(start)){
			curPath.add(start);
			for(String next : incoming.get(start)){
				buildPathsDFS(next, end, incoming, result, curPath);
			}
			curPath.remove(start);
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String start = "hit";
//		String	end = "cog";
//		Set<String> wordList = new HashSet<String>();
//		wordList.add("hot");
//		wordList.add("dot");
//		wordList.add("dog");
//		wordList.add("lot");
//		wordList.add("log");
//		
		String start = "a";
		String	end = "c";
		Set<String> wordList = new HashSet<String>();
		wordList.add("a");
		wordList.add("b");
		wordList.add("c");
	
		
		
		WordLadderIIBFSAndDFS ladder = new WordLadderIIBFSAndDFS();
		
		System.out.println(ladder.findLadders(start, end, wordList));

	}

}
