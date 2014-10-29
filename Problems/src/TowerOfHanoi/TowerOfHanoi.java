package TowerOfHanoi;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * problem to solve tower of hanoi give n start discs and 3 pegs
 * Input : number of discs n
 * Output : Print state after every move
 */

public class TowerOfHanoi {
	
	public static void move(Map<Integer,List<Integer>> tower , int peg1, int peg2){
		
		if(tower.get(peg2).isEmpty() && !tower.get(peg1).isEmpty() 
				|| (!tower.get(peg1).isEmpty() && tower.get(peg1).get(tower.get(peg1).size() - 1) < tower.get(peg2).get(tower.get(peg2).size() - 1) )){
				tower.get(peg2).add(tower.get(peg1).get(tower.get(peg1).size() - 1));
				tower.get(peg1).remove(tower.get(peg1).size() - 1);
			}else{
				tower.get(peg1).add(tower.get(peg2).get(tower.get(peg2).size() - 1));
				tower.get(peg2).remove(tower.get(peg2).size() - 1);
			}
		
	}
	
	public static void solve(Map<Integer,List<Integer>> tower){
		
		boolean done = false;
 		
		int numDiscs = tower.get(1).size();
		
		boolean oddNumDiscs = true;
		if(numDiscs%2==0){
			oddNumDiscs = false;
		}
		
		List<Integer> moveList = new LinkedList<Integer>();
		moveList.add(1); // ac odd
		moveList.add(2); // ab odd
		moveList.add(3); // bc odd
		
		int move = 0;
		
		System.out.println(tower);
		
		if(oddNumDiscs){

			while(!done){

				if(move == 0){
					move(tower, 1, 3);
				}else if(move == 1){
					move(tower, 1, 2);
				}else{
					move(tower, 2, 3);
				}

				if(tower.get(3).size() == numDiscs){
					done = true;
				}

				move++;
				if(move == 3)
					move = 0;

				System.out.println(tower);
			}

		}
		
		if(!oddNumDiscs){
			
			while(!done){

				if(move == 0){
					move(tower, 1, 2);
				}else if(move == 1){
					move(tower, 1, 3);
				}else{
					move(tower, 2, 3);
				}

				if(tower.get(3).size() == numDiscs){
					done = true;
				}

				move++;
				if(move == 3)
					move = 0;

				System.out.println(tower);
			}

		}
		
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int numDiscs = sc.nextInt();

 		Map<Integer,List<Integer>> tower = new HashMap<Integer,List<Integer>>();
 		List<Integer> aList = new LinkedList<Integer>();
 		for(int i = numDiscs ; i > 0 ; i --){
 			aList.add(i);
 		}
 		tower.put(1, aList);
 		tower.put(2, new LinkedList<Integer>());
 		tower.put(3, new LinkedList<Integer>());
 		
 		solve(tower);
 		
	}
	
}
