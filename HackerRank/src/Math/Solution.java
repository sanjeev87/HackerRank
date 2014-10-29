package Math;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void predictWinner(List<Integer> list){
		
		boolean gameOver = false;
		int turn = 0;
		
		while(!gameOver){
			
			List<List<Integer>> longSols = getLongestSolution(list);
			
			List<Integer> tempList = new LinkedList<Integer>(list);
			
			if((list.size() - longSols.get(0).size()) % 2 != 0){
				tempList.removeAll(longSols.get(0));
				list.remove(tempList.get(0));
			}else{
				List<Integer> intersectingElements = new LinkedList<Integer>(longSols.get(0));
				for(List<Integer> aLongSol : longSols){
					intersectingElements.retainAll(aLongSol);
				}
			
				if(intersectingElements.isEmpty() ){
					list.remove(longSols.get(0).get(0));
				}else{
					list.remove(intersectingElements.get(0));
				}
			}
			
			if(arrayIsAscending(list)){
				if(turn == 1){
					System.out.println("Bob");
					gameOver = true;
				}else{
					System.out.println("Alice");
					gameOver = true;
				}
			}
			
			turn = ( turn + 1 ) % 2;
			
		}
		
	}
	
	public static List<List<Integer>> getLongestSolution(List<Integer> list){
		
		
		List<List<Integer>> solLists = new LinkedList<List<Integer>>();
		
		for(int i = 0 ; i < list.size() ; i++){
			
			List<Integer> sol = new LinkedList<Integer>();
			sol.add(list.get(i));
			solLists.add(sol);
			
			List<List<Integer>> solListsCopy = new LinkedList<List<Integer>>(solLists);
			
			//for(int j = i ; j < list.size() ; j++ ){
				for(List<Integer> solutionsSoFar : solListsCopy){
					if(solutionsSoFar.get(solutionsSoFar.size() - 1) < list.get(i)){
						List<Integer> tempList = new LinkedList<Integer>(solutionsSoFar);
						tempList.add(list.get(i));
						if(!solLists.contains(tempList))
						solLists.add(tempList);
					}
			//	}
			}
		}
		
		Map<Integer,List<List<Integer>>> solutionSetMap = new HashMap<Integer,List<List<Integer>>>();
		
		for(List<Integer> solution : solLists){
			if(!solutionSetMap.containsKey(solution.size())){
				solutionSetMap.put(solution.size(), new LinkedList<List<Integer>>());
			}
			solutionSetMap.get(solution.size()).add(solution);
		}
		
		int maxSize = Collections.max(solutionSetMap.keySet());
		return solutionSetMap.get(maxSize);
		
		
	}
	
	public static boolean arrayIsAscending(List<Integer> list){
		
		int temp = list.get(0);
		
		for(int i : list){
			if(i >= temp){
				temp = i;
			}else{
				return false;
			}
		}
		
		return true;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i= 1 ; i <= T ; i++){
			int N = sc.nextInt();
			List<Integer> list = new LinkedList<Integer>();
			for(int j = 1 ; j <= N ; j ++){
				list.add(sc.nextInt());
			}
			predictWinner(list);
		}
		
		
	}

}
