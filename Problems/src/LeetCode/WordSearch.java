package LeetCode;

public class WordSearch {

	public boolean exist(char[][] board, int x, int y, boolean[][] used, String word) {
		
		if(word.length() == 0){
			return true;
		}
		
		if(board[x][y] == word.charAt(0) && !used[x][y]){
			used[x][y] = true;
			if(word.length() == 1){
				return true;
			}
			String subWord = word.substring(1);
			if(x+1 < board.length && exist(board, x+1, y, used,subWord)){
				return true;
			}
			if(y+1 < board[0].length && exist(board, x, y+1, used, subWord)){
				return true;
			}
			if(x-1 >= 0 &&exist(board, x-1, y, used, subWord)){
				return true;
			}
			if(y-1 >= 0 && exist(board, x, y-1, used, subWord)){
				return true;
			}
			used[x][y] = false;
		}
		return false;
	}
	
	
	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0){
			return false;
		}
		int m = board.length;
		int n = board[0].length;
		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				if(exist(board, i, j, new boolean[m][n], word)) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String word = "a";
		
		System.out.println(word);
		System.out.println("printngn subword" + word.substring(1));

	}

}
