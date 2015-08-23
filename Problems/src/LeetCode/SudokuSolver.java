package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuSolver {
	
	
	public boolean solveSudoku(char[][] board,
			boolean[][] orig,
			Map<Integer,Set<Character>> rowValues,
			Map<Integer,Set<Character>> columnValues,
			Map<Integer,Set<Character>> boxValues,
			int curX, int curY){
		
		if(curX == 9 && curY == 0 ){
			return true;
		}
		
		if(!orig[curX][curY]){
			for(char i = '1' ; i <= '9' ; i ++){
				int boxIndex = 10 * ((curX / 3) + 1) + ((curY / 3) + 1);
				if(!rowValues.get(curX).contains(i) 
						&& !columnValues.get(curY).contains(i)
						&& !boxValues.get(boxIndex).contains(i)){
					board[curX][curY] = i;
					
					rowValues.get(curX).add(i);
					columnValues.get(curY).add(i);
					boxValues.get(boxIndex).add(i);
					
					int newCurX = curX;
					int newCurY = curY;
					if(newCurY == 8){
						newCurY = 0;
						newCurX = curX+1;
					}else{
						newCurY = newCurY+1;
					}
					
					if(solveSudoku(board, orig, rowValues, columnValues, boxValues, newCurX, newCurY)){
						return true;
					}else{
						board[curX][curY] = '.';
						rowValues.get(curX).remove( i);
						columnValues.get(curY).remove(i);
						boxValues.get(boxIndex).remove(i);
					}
					
				}
			}
			
			return false;
			
		}else{
			if(curY == 8){
				curY = 0;
				curX = curX+1;
			}else{
				curY = curY+1;
			}
			return solveSudoku(board, orig, rowValues, columnValues, boxValues, curX, curY);
		}
		
	}

	public void solveSudoku(char[][] board) {

		int size = 9;
		
		Map<Integer,Set<Character>> rowValues = new HashMap<Integer, Set<Character>>();
		Map<Integer,Set<Character>> columnValues = new HashMap<Integer, Set<Character>>();
		Map<Integer,Set<Character>> boxValues = new HashMap<Integer, Set<Character>>();
		
		boolean[][] orig = new boolean[size][size];
		
		for(int i = 0 ; i < size ; i ++){
			for(int j = 0 ; j < size ; j ++){
				char c = board[i][j];
				if(!rowValues.containsKey(i)){
					rowValues.put(i, new HashSet<Character>());
				}
				if(!columnValues.containsKey(j)){
					columnValues.put(j, new HashSet<Character>());
				}
				int boxIndex = 10 * ((i / 3) + 1) + ((j / 3) + 1);
				if(!boxValues.containsKey(boxIndex)){
					boxValues.put(boxIndex, new HashSet<Character>());
				}
				
				if( c != '.'){
					orig[i][j] = true;
					rowValues.get(i).add(c);
					columnValues.get(j).add(c);
					boxValues.get(boxIndex).add(c);
				}
				
			}
		}
		
		
		solveSudoku(board, orig, rowValues, columnValues, boxValues, 0, 0);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'.','.','9','7','4','8','.','.','.'}, 
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}
				};
		
		SudokuSolver s = new SudokuSolver();
		s.solveSudoku(board);
		for(int i = 0 ; i < 9 ; i ++){
			String out = "";
			for(int j = 0 ; j < 9 ; j ++){
				out += board[i][j];
			}
			System.out.println(out);
		}
		
	}
	
	
}
