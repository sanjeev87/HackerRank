package LeetCode;

public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		int m = matrix.length;
		int n = matrix[0].length;
		int xSt = 0;
		int xEnd = m -1;
		int ySt = 0;
		int yEnd = n-1;
		int xmid = 0;
		
		if(m == 1 && n == 1){
			return matrix[0][0] == target;
		}
		
		while(xSt <= xEnd){
			xmid = (xSt + xEnd)/2;
			if(matrix[xmid][0] < target ){
				xSt = xmid+1;
			}else if(matrix[xmid][0] > target){
				xEnd = xmid - 1;
			}else{
				return true;
			}

		}
		
		while(matrix[xmid][0] > target && xmid >0){
			xmid--;
		}
		
		int ymid = 0;
		while(ySt <= yEnd){
			ymid = (ySt+yEnd)/2;
			if(matrix[xmid][ymid] < target ){
				ySt = ymid+1;
			}else if(matrix[xmid][ymid] > target){
				yEnd = ymid - 1;
			}else{
				return true;
			}
		}
		
		return matrix[xmid][ymid] == target;
	}

	public static void main(String[] args) {

		int[][] m = new int[1][2];
		
		m[0][0] = 1;
		m[0][1] = 3;
		Search2DMatrix s = new Search2DMatrix();
		System.out.println(s.searchMatrix(m, 3));
		
		
	}

}
