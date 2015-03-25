package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	
	class Pair{
		
		int rowIndex;
		int colIndex;
		
		public Pair(int rowIndex, int colIndex){
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
		}
		
	}
	
	public void bfs(char[][] board , int rowIndex, int colIndex){
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(rowIndex, colIndex));
		
		while(!q.isEmpty()){
			Pair p = q.remove();
			
			board[p.rowIndex][p.colIndex] = '+';
			
			if(p.rowIndex + 1 < board.length 
					&& board[p.rowIndex+1][p.colIndex] == 'O'){
			    board[p.rowIndex + 1][p.colIndex] = '+';
				q.add(new Pair(p.rowIndex + 1, p.colIndex));
			}
			
			if(p.rowIndex - 1 > 0
					&& board[p.rowIndex - 1][p.colIndex] == 'O'){
			    board[p.rowIndex - 1][p.colIndex] = '+';
				q.add(new Pair(p.rowIndex - 1, p.colIndex));
			}
			
			if(p.colIndex + 1 < board[0].length 
					&& board[p.rowIndex][p.colIndex+1] == 'O'){
			    board[p.rowIndex][p.colIndex + 1] = '+';
				q.add(new Pair(p.rowIndex , p.colIndex + 1));
			}
			
			if(p.colIndex - 1 > 0 
					&& board[p.rowIndex][p.colIndex - 1] == 'O'){
			    board[p.rowIndex][p.colIndex - 1] = '+';
				q.add(new Pair(p.rowIndex, p.colIndex - 1));
			}
		}
		
	}

	public void solve(char[][] board) {
		
		if(board.length == 0){
			return;
		}

		int rows = board.length;
		int columns = board[0].length;

		for(int i = 0 ; i < rows ; i++){
			if(board[i][0] == 'O'){
				bfs(board, i, 0);
			}

			if(board[i][columns-1] == 'O'){
				bfs(board, i, columns-1);
			}
		}
		
		for(int i = 0 ; i < columns ; i++){
			
			if(board[0][i] == 'O'){
				bfs(board, 0, i);
			}

			if(board[rows-1][i] == 'O'){
				bfs(board, rows - 1, i);
			}
			
		}

		for(int i = 0 ; i < rows ;i++){
			for(int j = 0 ; j < columns; j++){
				if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
				if(board[i][j] == '+'){
					board[i][j] = 'O';
				}
			}
		}
		
		
	}

	public static void main(String[] args) {
		char[][] board = new char[2][2];
		
		board[0][0] = 'O';
		board[1][0] = 'O';
		board[0][1] = 'O';
		board[1][1] = 'O';
		
		SurroundedRegions s = new SurroundedRegions();
		s.solve(board);
		System.out.println(board.toString());

	}

}
