package LeetCode;

import java.util.Stack;

public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {

		int numRows = matrix.length;
		if(numRows == 0){
		    return 0;
		}
		int numCols = matrix[0].length;
		int maxArea = 0;
		
		int[] height = new int[numCols+1];
		height[numCols] = 0;
		
		for(int row = 0 ; row < numRows ; row++){
			Stack<Integer> s = new Stack<Integer>();
			for(int col = 0 ; col < numCols+1 ; col++){
				
				if(col < numCols){
					if(matrix[row][col] == '1'){
						height[col] += 1;
					}else{
						height[col] = 0;
					}
				}
				
				
				if(s.isEmpty() || height[col] > height[s.peek()]){
					s.push(col);
				}else{
				    
				    while(!s.isEmpty() && (height[col] <= height[s.peek()]) ){
				        int top = s.pop();
					    int area = height[top] * (s.isEmpty() ? col : col - s.peek() - 1);
					    if(area > maxArea){
					    	maxArea = area;
					    }
				    }
					s.push(col);
				}
				
			}
		}
		
		
		return maxArea;
	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
