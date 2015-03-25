package LeetCode;

public class LongestCommonSubsequence {
	
	public static int getLCS(String s1, String s2){
		
		int m = s1.length();
		int n = s2.length();
		
		int[][] result = new int[m+1][n+1];
		
		for(int i = 0; i <= m ; i++){
			for(int j = 0 ; j <= n ; j++){
				
				if(i == 0 || j == 0){
					result[i][j] = 0;
				}else{
					
					if(s1.charAt(i-1) == s2.charAt(j-1)){
						result[i][j] = 1 + result[i-1][j-1];
					}else{
						result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
					}
					
					
				}
				
				
				
			}
			
		}
		
		int i = m;
		int j = n;
		
		StringBuilder out = new StringBuilder();
		
		while(i >= 1 && j >= 1){
			
			if(s1.charAt(i-1) == s2.charAt(j-1)){
				out.insert(0, s1.charAt(i-1));
				i--;
				j--;
			}else{
				
				if(result[i][j-1] >= result[i-1][j]){
					j--;
				}else{
					i--;
				}
				
			}
			
		}
				
		System.out.println(out.toString());
		return result[m][n];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "ABCDGH";
		String s2 = "AEDFHR";
		
		System.out.println(getLCS(s1, s2));
		
	}

}
