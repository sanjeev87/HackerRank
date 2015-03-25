package LeetCode;

public class EditDistance {

	public int minDistance(String word1, String word2) {

		int m = word1.length();
		int n = word2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 0 ; i < m+1 ; i++){
			for(int j = 0 ; j < n+1 ; j++){
				
				if(i == 0){
					dp[i][j] = j;
				}else if(j == 0){
					dp[i][j] = i;
				}else{
					int cost = 1;
					if(word1.charAt(i-1) == word2.charAt(j-1)){
						cost = 0;
					}
					
					dp[i][j] =  Math.min(dp[i-1][j-1] + cost, 
							Math.min(dp[i-1][j] + 1 ,dp[i][j-1]+1));
					
				}
				
			}
		}
		
		return dp[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
