package LeetCode;

public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int rows = obstacleGrid.length;
		int columns = obstacleGrid[0].length;
		int[][] result = new int[rows][columns];
		
		
		if(obstacleGrid[0][0] == 1){
			return 0;
		}
		
		result[0][0] = 1;
		
		
		for(int i = 0; i < rows ; i++){
			for(int j = 0 ; j < columns ; j ++){
				
				if(i == 0 && j == 0){
					continue;
				}
				
				if(obstacleGrid[i][j] == 1){
					result[i][j] = 0;
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
		
		return result[rows-1][columns-1];
	}



	public static void main(String[] args) {

		int[][] result = new int[3][5];

		System.out.println(result.length);
		System.out.println(result[0].length);

	}

}
