package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
	
	public void setRowZeros(int[][] matrix, int row){
		
		for(int k = 0 ; k < matrix[0].length ; k++){
			matrix[row][k] = 0;
		}
		
		
		
	}
	
	public void setColumnZeros(int[][] matrix , int column){
		for(int k = 0 ; k < matrix.length ; k++){
			matrix[k][column] = 0;
		}
	}
	

	public void setZeroes(int[][] matrix) {

		if(matrix.length == 0 ){
			return;
		}
		
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> columns = new HashSet<Integer>();
		
		for(int i = 0 ; i < matrix.length ; i++){
			for(int j = 0 ; j < matrix[0].length; j ++){
				
				if(matrix[i][j] == 0){
					rows.add(i);
					columns.add(j);
				}
			}
		}
		
		for(int row : rows){
			setRowZeros(matrix, row);
		}
		for(int column : columns){
			setColumnZeros(matrix, column);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
