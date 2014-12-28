package LeetCode;

public class UniquePaths {

	public int uniquePaths(int m, int n) {

		int[][] result = new int[m][n];
		
		result[0][0] = 1;
		
		for(int i = 0 ; i < m ; i ++){
			for(int j = 0 ; j < n ; j ++){
				
				if(i == 0 && j == 0){
					continue;
				}
				
				if(i == 0){
					result[i][j] = result[i][j-1];
					continue;
				}
				
				if(j == 0){
					result[i][j] = result[i-1][j];
					continue;
				}
				
				result[i][j] = result[i-1][j] + result[i][j-1];
				
			}
		}
		
		return result[m-1][n-1];
	}

}
