package LeetCode;

public class DistinctSubsequences {

	public int numDistinct(String S, String T) {
        
        

		if(T.isEmpty() && !S.isEmpty()){
			return 1;
		}
		
		if(T.isEmpty() && S.isEmpty()){
			return 0;
		}
		
		int[][] result = new int[S.length() + 1][T.length() + 1];
		
		for(int i = 0 ; i < S.length() + 1 ; i ++){
			result[i][0] = 1;
		}

		for(int i = 1 ; i < S.length() + 1 ; i ++){
			for(int j = 1 ; j < T.length() + 1 ; j++ ){
				
				//if no match, ignore the ith element of S and compare T(0,i) to S(0,j-1)
				result[i][j] = result[i-1][j];
				
				//if match, choose to ignore or include it 
				if(T.charAt(j-1) == S.charAt(i-1)){
					result[i][j] += result[i-1][j-1];
				}
			}
		}
		
		
		return result[S.length()][T.length()];
	
        
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
