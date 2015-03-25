package LeetCode;

import java.util.Arrays;

public class QueensII {
	
	 public int helper(int rowIndex,int n
				,boolean[] diag1, boolean[] diag2, boolean[] column,int count){
			
			if(rowIndex == n){
				// record scores and return;
				return count+1;
			}
			for(int colIndex = 0 ; colIndex < n ; colIndex++){
				
				int d1 = rowIndex - colIndex + n;
				int d2 = 2*n - rowIndex - colIndex - 1;
				
				if(!column[colIndex] && !diag1[d1] && !diag2[d2]){
					char[] row = new char[n];
					Arrays.fill(row, '.');
					row[colIndex] = 'Q';
					//curBoard[rowIndex] = new String(row);
					diag1[d1] = true;
					diag2[d2] = true;
					column[colIndex] = true;
					count = helper(rowIndex+1, n, diag1, diag2, column,count);
					Arrays.fill(row, '.');
					//curBoard[rowIndex] = new String(row);
					diag1[d1] = false;
					diag2[d2] = false;
					column[colIndex] = false;
				}
				
				
			}
			
			return count;
		}
	    
	    
	    
	    public int totalNQueens(int n) {
	        
	    	int count = 0;
			count = helper(0, n, new boolean[2*n], new boolean[2*n], new boolean[n],count);
			return count;
			
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
