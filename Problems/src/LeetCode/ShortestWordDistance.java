package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistance {

	public int shortestDistance(String[] words, String word1, String word2) {

		
		List<Integer> index1 = new ArrayList<Integer>();
		List<Integer> index2 = new ArrayList<Integer>();
		
		int shortest = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < words.length; i++){
			if(words[i].equals(word1)){
				index1.add(i);
			}
			if(words[i].equals(word2)){
				index2.add(i);
			}
		}
		
		for(int i1 : index1){
			for(int i2: index2){
				if(shortest > Math.abs(i2 - i1)){
					shortest = Math.abs(i2 - i1);
				}
			}
		}
		
		return shortest;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
