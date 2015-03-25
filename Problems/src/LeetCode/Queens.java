package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queens {

	
    public void helper(int rowIndex,int n,List<String[]> result
			,boolean[] diag1, boolean[] diag2, boolean[] column, String[] curBoard){
		
		if(rowIndex == n){
			// record scores and return;
			result.add(curBoard.clone());
			return;
		}
		for(int colIndex = 0 ; colIndex < n ; colIndex++){
			
			int d1 = rowIndex - colIndex + n;
			int d2 = 2*n - rowIndex - colIndex - 1;
			
			if(!column[colIndex] && !diag1[d1] && !diag2[d2]){
				char[] row = new char[n];
				Arrays.fill(row, '.');
				row[colIndex] = 'Q';
				curBoard[rowIndex] = new String(row);
				diag1[d1] = true;
				diag2[d2] = true;
				column[colIndex] = true;
				helper(rowIndex+1, n, result, diag1, diag2, column,curBoard);
				Arrays.fill(row, '.');
				curBoard[rowIndex] = new String(row);
				diag1[d1] = false;
				diag2[d2] = false;
				column[colIndex] = false;
			}
			
			
		}
		
		
	}
	

	public List<String[]> solveNQueens(int n) {
		
		List<String[]> result = new ArrayList<String[]>();
		String[] curBoard = new String[n];
		
		helper(0, n, result, new boolean[2*n], new boolean[2*n], new boolean[n],curBoard);
		
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queens q = new Queens();
	
		List<String[]> result = q.solveNQueens(4);
		System.out.println(result.size());
		int i = 0;
		for(String[] r : result){
			System.out.println("printing result " + i++);
			for(int j = 0 ; j < r.length ; j ++){
				System.out.println(r[j]);
			}
		}
		

	}

}
