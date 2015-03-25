package Interview;

public class Boggle {
	

	public boolean nextStep(char[][] board, String word, 
			boolean[][] used, StringBuilder out, int startX, int startY){
		
		if(out.length() == word.length()){
			return true;
		}
		
		if(startX >= 0 && startX < board.length 
				&& startY >= 0 && startY < board[0].length
				&& !used[startX][startY] 
				&& board[startX][startY] == word.charAt(out.length())){
			
			used[startX][startY] = true;
			out.append(board[startX][startY]);
			if(doesWordExist(board, word, used, out, startX, startY)){
				return true;
			}
			used[startX][startY] = false;
			out.setLength(out.length()-1);
		}
		
	
		return false;
	}
	
	public boolean doesWordExist(char[][] board, String word, 
			boolean[][] used, StringBuilder out, int startX, int startY){
		
		if(out.length() == word.length()){
			return true;
		}
		
		if(nextStep(board, word, used, out, startX, startY)){
			return true;
		}
		
		if(nextStep(board, word, used, out, startX-1, startY)){
			return true;
		}
		
		if(nextStep(board, word, used, out, startX-1, startY+1)){
			return true;
		}
		
		if(nextStep(board, word, used, out, startX, startY+1)){
			return true;
		}
		if(nextStep(board, word, used, out, startX+1, startY+1)){
			return true;
		}
		if(nextStep(board, word, used, out, startX+1, startY)){
			return true;
		}
		if(nextStep(board, word, used, out, startX+1, startY-1)){
			return true;
		}
		if(nextStep(board, word, used, out, startX, startY-1)){
			return true;
		}
		if(nextStep(board, word, used, out, startX-1, startY-1)){
			return true;
		}
		
		return false;
	}
	

	
	
	
	public boolean doesWordExist(char[][] board, String word){
	
		int m = board.length;
		int n = board[0].length;
		
		
		for(int i = 0 ; i < m ; i ++){
			for(int j = 0 ; j < n ; j++){
				StringBuilder out = new StringBuilder();
				boolean[][] used = new boolean[m][n];
				if(doesWordExist(board, word, used, out, i, j)){
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		char[][] board = new char[4][4];
		
		board[0][0] = 'S';
		board[0][1] = 'M';
		board[0][2] = 'E';
		board[0][3] = 'F';
		board[1][0] = 'R';
		board[1][1] = 'A';
		board[1][2] = 'T';
		board[1][3] = 'D';
		board[2][0] = 'L';
		board[2][1] = 'O';
		board[2][2] = 'N';
		board[2][3] = 'I';
		board[3][0] = 'K';
		board[3][1] = 'A';
		board[3][2] = 'F';
		board[3][3] = 'B';
		
		String word = "TRAD";
		
		
		Boggle b = new Boggle();
		
		System.out.println(b.doesWordExist(board, word));
		

	}

}
