package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
	
	public class WordDistance {
	    String[] words;
	    Map<String,Integer> resultMap;
	    Map<String,List<Integer>> indicesMap;
	    
	    
	    public WordDistance(String[] words) {
	        this.words = words;
	        this.resultMap = new HashMap<String, Integer>();
	        this.indicesMap = new HashMap<String, List<Integer>>();
	        
	        for(int i = 0 ; i < words.length; i++){
				if(!indicesMap.containsKey(words[i])){
					indicesMap.put(words[i], new ArrayList<Integer>());
				}
				indicesMap.get(words[i]).add(i);
			}
	        
	    }

	    public int shortest(String word1, String word2) {
	    	String key = "";
	    	if(word1.compareToIgnoreCase(word2) > 0){
	    		key = word1+"-"+word2;
	    	}else{
	    		key = word2+"-"+word1;
	    	}
	    	
	    	if(resultMap.containsKey(key)){
	    		return resultMap.get(key);
	    	}
	    	
	        List<Integer> index1 = this.indicesMap.get(word1);
			List<Integer> index2 = this.indicesMap.get(word2);
			int shortest = Integer.MAX_VALUE;
			for(int i1 : index1){
				for(int i2: index2){
					if(shortest > Math.abs(i2 - i1)){
						shortest = Math.abs(i2 - i1);
					}
				}
			}
			resultMap.put(key, shortest);
			return shortest;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
